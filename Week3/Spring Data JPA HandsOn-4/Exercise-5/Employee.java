import jakarta.persistence.*;
@Entity
@NamedQueries({
    @NamedQuery(name = "Employee.findByExactName",
                query = "SELECT e FROM Employee e WHERE e.name = :name"),

    
    @NamedQuery(name = "Employee.findAllSortedBySalary",
                query = "SELECT e FROM Employee e ORDER BY e.salary DESC")
})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double salary;
    @ManyToOne
    private Department department;

   
}

