package ru.isands.test.estore.service;

import ru.isands.test.estore.dao.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee getEmployee(long id);

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(long id);
}