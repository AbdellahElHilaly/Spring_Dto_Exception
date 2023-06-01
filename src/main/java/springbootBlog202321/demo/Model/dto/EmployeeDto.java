package springbootBlog202321.demo.Model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springbootBlog202321.demo.Model.entity.Employee;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;

    public static EmployeeDto toDto(Employee entity) {
       return EmployeeDto.builder()
               .id(entity.getId())
               .firstName(entity.getFirstName())
               .lastName(entity.getLastName())
               .email(entity.getEmail())
               .build();
    }







}
