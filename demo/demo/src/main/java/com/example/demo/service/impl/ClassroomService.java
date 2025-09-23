package com.example.demo.service.impl;


import com.example.demo.entity.Classroom;
import com.example.demo.repository.IClassroomRepository;
import com.example.demo.service.IClassroomService;
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
