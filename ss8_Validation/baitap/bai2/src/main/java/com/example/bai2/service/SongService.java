package com.example.bai2.service;

import com.example.bai2.entity.Song;
import com.example.bai2.repository.ISongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService {
    private final ISongRepository repository;

    public SongService(ISongRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Song> findAll() {
        return repository.findAll();
    }

    @Override
    public Song save(Song song) {
        return repository.save(song);
    }

    @Override
    public Optional<Song> findById(Integer id) {
        return repository.findById(id);
    }
}
