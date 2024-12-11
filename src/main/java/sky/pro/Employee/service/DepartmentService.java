package sky.pro.Employee.service;

import org.springframework.stereotype.Service;
import sky.pro.Employee.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private EmployeeServiceImpl employeeService;

    public DepartmentService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getEmployeeWithMaxSalaryByDepartment(String departmentId) {
        List<Employee> employees = employeeService.findAll();
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee getEmployeeWithMinSalaryByDepartment(String departmentId) {
        List<Employee> employees = employeeService.findAll();
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Map<String, List<Employee>> getAllEmployeesByDepartments() {
        List<Employee> employees = employeeService.findAll();
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public Map<String, List<Employee>> getAllEmployeesByDepartment(String departmentId) {
        List<Employee> employees = employeeService.findAll();
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
