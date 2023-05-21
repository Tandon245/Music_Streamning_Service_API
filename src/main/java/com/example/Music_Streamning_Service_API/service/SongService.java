package com.example.Music_Streamning_Service_API.service;


import com.example.Music_Streamning_Service_API.model.Song;
import com.example.Music_Streamning_Service_API.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    private ISongRepository songRepository;

    public Song addSong(Song song) {
        return songRepository.save(song);
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Song getSongById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    public Song updateSong(Long id, Song song) {
        Song existingSong = songRepository.findById(id).orElse(null);
        if (existingSong != null) {
            existingSong.setTitle(song.getTitle());
            existingSong.setArtist(song.getArtist());
            existingSong.setGenre(song.getGenre());
            return songRepository.save(existingSong);
        } else {
            return null;
        }
    }

    public boolean deleteSong(Long id) {
        Song existingSong = songRepository.findById(id).orElse(null);
        if (existingSong != null) {
            songRepository.delete(existingSong);
            return true;
        } else {
            return false;
        }
    }
}