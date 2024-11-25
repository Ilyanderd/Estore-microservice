package ru.isands.test.estore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dao.entity.Employee;
import ru.isands.test.estore.dao.repo.EmployeeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public List<Employee> getEmployees() {
        if (repository.findAll().isEmpty()) {
            throw new IllegalArgumentException("List of employees is empty");
        }

        return repository.findAll();
    }

    @Override
    public Employee getEmployee(long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Employee with id " + id + " does not exist");
        }

        return repository.findById(id).get();
    }

    @Override
    public void addEmployee(Employee employee) {
        if (repository.existsById(employee.getId())) {
            throw new IllegalArgumentException("Employee already exists");
        }

        repository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        if (!repository.existsById(employee.getId())) {
            throw new IllegalArgumentException("Employee does not exist");
        }

        repository.save(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Employee does not exist");
        }

        repository.deleteById(id);
    }
}
