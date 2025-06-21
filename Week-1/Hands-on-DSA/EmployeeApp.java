class Employee {
    String id, name, position;
    double salary;

    public Employee(String id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}

public class EmployeeApp {
    public static void addEmployee(Employee[] arr, int index, Employee e) {
        arr[index] = e;
    }

    public static Employee searchEmployee(Employee[] arr, String id) {
        for (Employee e : arr) {
            if (e != null && e.id.equals(id))
                return e;
        }
        return null;
    }

    public static void deleteEmployee(Employee[] arr, String id) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].id.equals(id))
                arr[i] = null;
        }
    }

    public static void traverse(Employee[] arr) {
        for (Employee e : arr) {
            if (e != null) {
                System.out.println(e.id + " | " + e.name);
            }
        }
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        addEmployee(employees, 0, new Employee("E101", "John", "Manager", 5000));
        addEmployee(employees, 1, new Employee("E102", "Sarah", "Engineer", 4000));

        System.out.println("--- All Employees ---");
        traverse(employees);

        System.out.println("--- Searching E102 ---");
        Employee found = searchEmployee(employees, "E102");
        System.out.println(found != null ? found.name + " found" : "Not found");

        deleteEmployee(employees, "E101");
        System.out.println("--- After Deleting E101 ---");
        traverse(employees);
    }
}

