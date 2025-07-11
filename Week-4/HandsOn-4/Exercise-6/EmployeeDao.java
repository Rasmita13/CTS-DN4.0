public void deleteEmployee(int id) throws EmployeeNotFoundException {
    boolean removed = employeeList.removeIf(emp -> emp.getId().equals(id));
    if (!removed) {
        throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
    }
}

