package com.codegym.c0525g1.repository;

import com.codegym.c0525g1.entity.Student;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
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
//        HQL
        String temp = "%"+""+"%";
        List<Student> students = BaseRepository.entityManager
                .createQuery("select s from students as s where s.name like :name")
                .setParameter("name", temp).getResultList();
        return students;
    }

    public void save(Student student) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(student);
        transaction.commit();
    }

    public Student findById(Integer id) {
        Student student = BaseRepository.entityManager.find(Student.class, id);
        return student;
    }

    public void delete(Student student) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.remove(student);
        transaction.commit();
    }
}
