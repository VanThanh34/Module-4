package com.codegym.c0525g1_spring_boot.dto;

import com.codegym.c0525g1_spring_boot.entity.Classroom;
import com.codegym.c0525g1_spring_boot.validation.UniqueEmail;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Integer id;

    @Pattern(regexp = "^[A-Za-z ]{3,100}$", message = "Tên phải  đúng định dạng. Vd: Nguyen Van A")
    @Column(name = "name_student")
    private String name;

    @Column(name = "date_create")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Ngày tháng năm sinh không được để trống")
    private LocalDate dob;

    @Range(min = 0, max = 10, message = "Điểm phải nằm trong khoảng từ 0 đến 10")
    @NotNull(message = "Điểm không được  để trống")
    private Double point;

    //    fetch và cascade
    @ManyToOne
    @JoinColumn(name = "id_class", referencedColumnName = "id")
    @NotNull(message = "Lớp không được để trống")
    private Classroom classroom;

}
