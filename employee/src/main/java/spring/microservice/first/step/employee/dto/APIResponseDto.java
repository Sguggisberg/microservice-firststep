package spring.microservice.first.step.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIResponseDto {
    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;

}
