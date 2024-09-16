package spring.microservice.first.step.employee.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import spring.microservice.first.step.employee.dto.APIResponseDto;
import spring.microservice.first.step.employee.dto.DepartmentDto;
import spring.microservice.first.step.employee.dto.EmployeeDto;
import spring.microservice.first.step.employee.entity.Employee;
import spring.microservice.first.step.employee.repository.EmployeeRepository;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    // Obsolete
   //  private final RestTemplate restTemplate;

    private final WebClient webClient;

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

// Obsolete:
//        ResponseEntity<DepartmentDto> departmentDtoResponseEntity = restTemplate.getForEntity("http://localhost:8082/api/department/"
//            + employee.getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto departmentDto = departmentDtoResponseEntity.getBody();

        DepartmentDto departmentDto = webClient.get().uri("http://localhost:8082/api/department/"+ employee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();


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
