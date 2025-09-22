package com.codegym.c0525g1_spring_boot.repository;

import com.codegym.c0525g1_spring_boot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "select s from students as s where s.name like :name")
//    Trong  trường hợp có sự thay đổi dữ liệu
//    @Transactional
//    @Modifying <=> executeUpdate
    List<Student> findByName(@Param("name")String name);
}
