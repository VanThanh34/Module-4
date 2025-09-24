package com.codegym.c0525g1_spring_boot.service;

import com.codegym.c0525g1_spring_boot.entity.Student;
import org.springframework.data.domain.Page;

public interface IStudentService extends IService<Student> {
    Page<Student> findAllPageable(int page);
}
