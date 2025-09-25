package com.example.bai1.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @Pattern(regexp = "^[A-Za-z ]{5,45}$", message = "Tên phải đúng định dạng. như là Nguyen Van A.")
    private String firstName;

    @Pattern(regexp = "^[A-Za-z]{5,45}$", message = "Tên phải đúng định dạng. như là Nguyen Van A.")
    private String lastName;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "Ngày tháng năm sinh không được để trống")
    private LocalDate dob;

    @NotNull(message = "Số điện thoại không được để trống.")
    private Integer phone;

    @Email(message = "Email phải đúng định dạng")
    private String email;
}
