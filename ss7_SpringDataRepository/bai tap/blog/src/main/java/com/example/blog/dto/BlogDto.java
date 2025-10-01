package com.example.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {


    @NotNull(message = "Ngày không được để trống")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate day;

    @NotBlank(message = "Mô tả không được để trống")
    @Size(max = 255, message = "Mô tả không vượt quá 255 ký tự")
    private String description;

    @NotBlank(message = "Nội dung không được để trống")
    private String context;

    @NotNull(message = "Danh mục không được để trống")
    private Integer categoryId;
}
