package sit.int204.classicmodelsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
