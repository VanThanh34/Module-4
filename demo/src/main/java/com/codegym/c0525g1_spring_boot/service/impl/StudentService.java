package com.codegym.c0525g1_spring_boot.service.impl;

import com.codegym.c0525g1_spring_boot.entity.Student;
import com.codegym.c0525g1_spring_boot.repository.IStudentRepository;
import com.codegym.c0525g1_spring_boot.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

//    Field DI
//    setter DI
//    Constructor DI
    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }
}
