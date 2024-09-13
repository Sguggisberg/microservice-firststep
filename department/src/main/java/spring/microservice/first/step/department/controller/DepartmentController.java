package spring.microservice.first.step.department.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.microservice.first.step.department.dto.DepartmentDto;
import spring.microservice.first.step.department.service.DepartmentService;

@RestController
@RequestMapping("api/department")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> save(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartmentDto =departmentService.save(departmentDto);
        return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
    }

    @GetMapping({"{code}"})
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable String code) {
        return new ResponseEntity<>(departmentService.getDepartmentByCode(code), HttpStatus.OK);
    }

}
