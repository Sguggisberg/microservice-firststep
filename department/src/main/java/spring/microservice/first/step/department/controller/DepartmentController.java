package spring.microservice.first.step.department.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DepartmentDto> save(@RequestBody  DepartmentDto departmentDto){
        departmentService.save(departmentDto);
        return new ResponseEntity<>(departmentService.save(departmentDto), HttpStatus.CREATED);
    }

}
