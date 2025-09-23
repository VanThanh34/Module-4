package com.codegym.c0525g1_spring_boot.service.impl;

import com.codegym.c0525g1_spring_boot.entity.Classroom;
import com.codegym.c0525g1_spring_boot.repository.IClassroomRepository;
import com.codegym.c0525g1_spring_boot.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService implements IClassroomService {

    private final IClassroomRepository classroomRepository;

    public ClassroomService(IClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    @Override
    public void save(Classroom classroom) {
            classroomRepository.save(classroom);
    }

    @Override
    public Classroom findById(Integer id) {
        return classroomRepository.findById(id).orElse(null);
    }
}
