package spring.microservice.first.step.employee.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.microservice.first.step.employee.dto.APIResponseDto;
import spring.microservice.first.step.employee.dto.DepartmentDto;
import spring.microservice.first.step.employee.dto.EmployeeDto;
import spring.microservice.first.step.employee.entity.Employee;
import spring.microservice.first.step.employee.repository.EmployeeRepository;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {

        Employee employee = Employee.builder()
            .id(employeeDto.getId())
            .email(employeeDto.getEmail())
            .lastName(employeeDto.getLastName())
            .firstName(employeeDto.getFirstName())
            .departmentCode(employeeDto.getDepartmentCode())
            .build();
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeDto.builder()
            .email(savedEmployee.getEmail())
            .firstName(savedEmployee.getFirstName())
            .lastName(savedEmployee.getLastName())
            .id(savedEmployee.getId())
            .departmentCode(employee.getDepartmentCode())
            .build();
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.getReferenceById(id);

        ResponseEntity<DepartmentDto> departmentDtoResponseEntity = restTemplate.getForEntity("http://localhost:8082/api/department/"
            + employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto = departmentDtoResponseEntity.getBody();

        EmployeeDto employeeDto =
            EmployeeDto.builder()
                .email(employee.getEmail())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .id(employee.getId())
                .departmentCode(employee.getDepartmentCode())
                .build();
        return APIResponseDto.builder()
            .departmentDto(departmentDto)
            .employeeDto(employeeDto)
            .build();
    }
}
