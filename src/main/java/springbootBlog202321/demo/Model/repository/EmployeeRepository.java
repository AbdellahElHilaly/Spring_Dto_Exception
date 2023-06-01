package springbootBlog202321.demo.Model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import springbootBlog202321.demo.Model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}