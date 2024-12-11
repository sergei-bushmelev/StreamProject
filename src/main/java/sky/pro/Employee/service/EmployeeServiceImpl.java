package sky.pro.Employee.service;

import org.springframework.stereotype.Service;
import sky.pro.Employee.exeptoins.EmployeeAlreadyAddedException;
import sky.pro.Employee.exeptoins.EmployeeNotFoundException;
import sky.pro.Employee.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl {

    private final Map<String, Employee> employeeMap = new HashMap<>();

    public Employee add(String firstName, String lastName, int salary, String department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(employee.getFullName(), employee);
        return employee;
    }

    public Employee remove(String firstName, String lastName, int salary, String department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employeeMap.containsKey(employee.getFullName())) {
            return employeeMap.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    public Employee find(String firstName, String lastName, int salary, String department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employeeMap.containsKey(employee.getFullName())) {
            return employeeMap.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employeeMap.values());
    }
}
    