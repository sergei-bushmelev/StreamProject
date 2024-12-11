package sky.pro.Employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.Employee.model.Employee;
import sky.pro.Employee.service.EmployeeServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl service;

    public EmployeeController(EmployeeServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam String department) {
        return service.add(firstName, lastName, salary, department);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam String department) {
        return service.remove(firstName, lastName, salary, department);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam String department) {
        return service.find(firstName, lastName, salary, department);
    }

    @GetMapping
    public Collection<Employee> findAll(){
        return service.findAll();
    }

}
