package com.codegym.c0525g1.repository;

import com.codegym.c0525g1.entity.Student;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "haiTT", LocalDate.now(), 10.0));
        students.add(new Student(2, "haiTT", LocalDate.now(), null));
        students.add(new Student(3, "haiTT", LocalDate.now(), 10.0));
    }

    public List<Student> findAll() {

        return students;
    }

    public void save(Student student) {
        Integer id = students.get(students.size() - 1).getId() + 1;
        student.setId(id);
        students.add(student);
    }

    public Student findById(Integer id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
}
