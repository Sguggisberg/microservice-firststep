package spring.microservice.first.step.department.service;

import spring.microservice.first.step.department.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto save(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String code);


}
