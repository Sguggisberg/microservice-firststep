package spring.microservice.first.step.employee.service;

import spring.microservice.first.step.employee.dto.APIResponseDto;
import spring.microservice.first.step.employee.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto save(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long id);
}
