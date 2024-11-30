package ru.isands.test.estore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.isands.test.estore.dao.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Page<Employee> getEmployees(int page, int size);

    List<Employee> getEmployees();

    Employee getEmployee(long id);

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(long id);
}