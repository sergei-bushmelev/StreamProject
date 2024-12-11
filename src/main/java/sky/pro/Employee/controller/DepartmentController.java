package sky.pro.Employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.Employee.model.Employee;
import sky.pro.Employee.service.DepartmentService;
import sky.pro.Employee.service.EmployeeServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final EmployeeServiceImpl employeeService;

    public DepartmentController(DepartmentService departmentService, EmployeeServiceImpl employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalaryByDepartment(@RequestParam("departmentId") String departmentId) {
        return departmentService.getEmployeeWithMaxSalaryByDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalaryByDepartment(@RequestParam("departmentId") String departmentId) {
        return departmentService.getEmployeeWithMinSalaryByDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<String, List<Employee>> getAllEmployeesByDepartment(@RequestParam(value = "departmentId", required = false) String departmentId) {
        if (departmentId == null) {
            return departmentService.getAllEmployeesByDepartments();
        }
        return departmentService.getAllEmployeesByDepartment(departmentId);
    }
}
