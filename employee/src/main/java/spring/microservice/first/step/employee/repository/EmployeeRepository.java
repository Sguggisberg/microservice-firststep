package spring.microservice.first.step.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.microservice.first.step.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
