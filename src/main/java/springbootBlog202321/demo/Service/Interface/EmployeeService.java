package springbootBlog202321.demo.Service.Interface;

import springbootBlog202321.demo.Model.dto.EmployeeDto;
import springbootBlog202321.demo.Model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    EmployeeDto getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id);
    void deleteEmployee(long id);
}