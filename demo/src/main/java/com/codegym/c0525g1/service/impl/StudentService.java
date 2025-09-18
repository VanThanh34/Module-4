package com.codegym.c0525g1.service.impl;

import com.codegym.c0525g1.entity.Student;
import com.codegym.c0525g1.repository.StudentRepository;
import com.codegym.c0525g1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

//    Field DI
//    setter DI
//    Constructor DI
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
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
        return studentRepository.findById(id);
    }
}
