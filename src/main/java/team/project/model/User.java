package team.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Email không được trống")
    @Email(message = "Email không hợp lệ")
    String email;

    @NotBlank(message = "Mật Khẩu không được trống")
    @Size(min = 6, message = "Mật khẩu phải trên 6 ký tự")
    String password;

    @NotBlank(message = "Số điện thoại không được trống")
    @Pattern(regexp = "^\\+?[0-9]*$", message = "Số điện thoại không đúng định dạng")
    String phone;

    @NotBlank(message = "Địa chỉ không được trống")
    String address;

    String fullName;

    String gender;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @ToString.Exclude
    Role role;
}
