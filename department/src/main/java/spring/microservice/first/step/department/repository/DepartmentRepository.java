package spring.microservice.first.step.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.microservice.first.step.department.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findDepartmentByCode(String code);
}
