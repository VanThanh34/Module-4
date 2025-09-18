package com.codegym.c0525g1.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Student {
    private Integer id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    private Double point;

    public Student() {
    }

    public Student(Integer id, String name, LocalDate dob, Double point) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.point = point;
    }

    public Student(String name, LocalDate localDate, Double point) {
        this.name = name;
        this.dob = localDate;
        this.point = point;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }
}
