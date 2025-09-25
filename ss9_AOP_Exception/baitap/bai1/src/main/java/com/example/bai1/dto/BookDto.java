package com.example.bai1.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;

public class BookDto {
    @Pattern(regexp = "^[A-Za-z ,1-9]{5,800}$", message = "Tên sách phải đúng định dạng và không vượt quá 800 kí tự. VD: Dac Nhan Tam")
    private String name;

    @Pattern(regexp = "^[A-Za-z ]{5,300}$", message = "Tên tác giả phải đúng định dạng và không vượt quá 300 kí tự. VD: Vo Van Thanh")
    private String author;

    @Column(name = "book_category")
    private String category;

    @Column(name = "book_quantity")
    private Integer quantity;
}
