package team.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vaccine")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Tên vaccine không được trống")
    String name;

    @NotNull(message = "Giá không được trống")
    Integer price;

    @NotBlank(message = "Nơi sản xuất không được trống")
    String country;

    @NotBlank(message = "Bệnh không được trống")
    String disease;

    @NotBlank(message = "Mô tả không được trống")
    String description;

    @NotBlank(message = "URL Hình ảnh không được trống")
    String image;

    @Min(value = 1, message = "Số lượng không được nhỏ hơn 1")
    Integer quantity;

}

