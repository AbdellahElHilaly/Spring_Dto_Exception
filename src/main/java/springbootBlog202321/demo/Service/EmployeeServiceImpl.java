package springbootBlog202321.demo.Service;


import org.springframework.stereotype.Service;
import springbootBlog202321.demo.Exception.handler.ResourceNotFoundException;
import springbootBlog202321.demo.Model.dto.EmployeeDto;
import springbootBlog202321.demo.Model.entity.Employee;
import springbootBlog202321.demo.Model.repository.EmployeeRepository;
import springbootBlog202321.demo.Service.Interface.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeDto getEmployeeById(long id) {
        Employee employee = this.findOrFails(id);
        return  EmployeeDto.toDto(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = this.findOrFails(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;

    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.delete(this.findOrFails(id));
    }

    public Employee findOrFails(long id){
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }

}
