package spring.microservice.first.step.employee.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.microservice.first.step.employee.dto.EmployeeDto;
import spring.microservice.first.step.employee.entity.Employee;
import spring.microservice.first.step.employee.repository.EmployeeRepository;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {

        Employee employee = Employee.builder()
            .id(employeeDto.getId())
            .email(employeeDto.getEmail())
            .lastName(employeeDto.getLastName())
            .firstName(employeeDto.getFirstName())
            .build();
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeDto.builder()
            .email(savedEmployee.getEmail())
            .firstName(savedEmployee.getFirstName())
            .lastName(savedEmployee.getLastName())
            .id(savedEmployee.getId())
            .build();
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.getReferenceById(id);
        return EmployeeDto.builder()
            .email(employee.getEmail())
            .firstName(employee.getFirstName())
            .lastName(employee.getLastName())
            .id(employee.getId())
            .build();
    }
}
