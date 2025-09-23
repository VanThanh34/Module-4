package com.example.blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Integer id;

    @Column(name = "blog_day")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate day;

    @Column(name = "blog_description")
    private String description;

    @Column(name = "blog_context", nullable = false)
    private String context;

    @ManyToOne
    @JoinColumn(name = "id_category", referencedColumnName = "category_id")
    private Category category;
}
