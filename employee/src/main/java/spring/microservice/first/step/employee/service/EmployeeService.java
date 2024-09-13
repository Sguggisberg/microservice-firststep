package spring.microservice.first.step.employee.service;

import spring.microservice.first.step.employee.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto save(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
}
