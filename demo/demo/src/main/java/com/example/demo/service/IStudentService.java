package com.example.demo.service;


import com.example.demo.entity.Student;
import org.springframework.data.domain.Page;

public interface IStudentService extends IService<Student> {
    Page<Student> findAllPageable(int page);
}
