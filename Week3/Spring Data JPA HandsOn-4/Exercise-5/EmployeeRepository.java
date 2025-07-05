import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentName(String departmentName);
    List<Employee> findBySalaryGreaterThan(Double salary);
    List<Employee> findByNameContaining(String keyword);
}
@Query("SELECT e FROM Employee e WHERE e.salary > :minSalary")
List<Employee> getEmployeesWithSalaryAbove(@Param("minSalary") Double minSalary);
@Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
List<Employee> getEmployeesByDepartment(@Param("deptName") String departmentName);



