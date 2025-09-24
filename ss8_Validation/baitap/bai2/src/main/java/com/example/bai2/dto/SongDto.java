package com.example.bai2.dto;


import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {

    @Pattern(regexp = "^[A-Za-z ]{5,800}$", message = "Tên bài hát phải đúng định dạng và không vượt quá 800 kí tự. VD: Con Mua Ngang Qua")
    private String name;

    @Pattern(regexp = "^[A-Za-z ]{5,300}$", message = "Tên nghệ sĩ phải đúng định dạng và không vượt quá 300 kí tự. VD: Son Tung MTP")
    private String ngheSi;

    @Pattern(regexp = "^[A-Za-z, ]{1,1000}$", message = "Thể loại nhạc không vượt quá 1000 kí tự. VD: Ballad")
    private String theLoai;
}
