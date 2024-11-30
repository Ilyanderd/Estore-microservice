package ru.isands.test.estore.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.isands.test.estore.dao.entity.Employee;
import ru.isands.test.estore.service.EmployeeService;

import java.util.Date;

@Controller
@AllArgsConstructor
public class EmployeeMvcController {

    private EmployeeService service;

    @GetMapping("/employees")
    public String employee(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Model model) {
        Page<Employee> employeesPage = service.getEmployees(page, size);

        model.addAttribute("employees", employeesPage);
        model.addAttribute("title", "Сотрудники");

        return "employee";
    }

    @GetMapping("/employees/add")
    public String showAddEmployee() {
        return "addEmployee";
    }

    @PostMapping("/employees/add")
    public String addEmployee(@RequestParam(defaultValue = "0") long id, @RequestParam String lastName, @RequestParam String firstName,
                              @RequestParam String patronymic, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDate,
                              @RequestParam long positionId, @RequestParam long shopId, @RequestParam boolean gender) {

        Employee employee = new Employee(id, lastName, firstName, patronymic, birthDate, positionId, shopId, gender);

        service.addEmployee(employee);

        return "redirect:/employees";
    }
}
