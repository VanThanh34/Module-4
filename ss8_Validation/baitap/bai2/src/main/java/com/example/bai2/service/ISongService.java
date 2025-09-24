package com.example.bai2.service;

import com.example.bai2.entity.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();
    Song save(Song song);
    Optional<Song> findById(Integer id);
}
