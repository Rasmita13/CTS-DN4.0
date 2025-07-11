@DeleteMapping("/{id}")
public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
    employeeService.deleteEmployee(id);
}

