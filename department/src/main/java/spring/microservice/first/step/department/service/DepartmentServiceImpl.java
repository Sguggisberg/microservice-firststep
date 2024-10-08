package spring.microservice.first.step.department.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.microservice.first.step.department.dto.DepartmentDto;
import spring.microservice.first.step.department.entity.Department;
import spring.microservice.first.step.department.repository.DepartmentRepository;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {

        Department department = Department.builder()
            .id(departmentDto.getId())
            .code(departmentDto.getCode())
            .name(departmentDto.getName())
            .description(departmentDto.getDescription())
            .build();
        Department savedDepartmant = departmentRepository.save(department);

       return DepartmentDto.builder()
            .description(savedDepartmant.getDescription())
            .code(savedDepartmant.getCode())
            .name(savedDepartmant.getName())
            .id(savedDepartmant.getId())
            .build();
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findDepartmentByCode(code);

        return DepartmentDto.builder()
            .description(department.getDescription())
            .code(department.getCode())
            .name(department.getName())
            .id(department.getId())
            .build();
    }
}
