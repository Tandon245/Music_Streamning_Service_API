package com.example.Music_Streamning_Service_API.service;


import com.example.Music_Streamning_Service_API.model.Playlist;
import com.example.Music_Streamning_Service_API.repository.IPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    @Autowired
    private IPlaylistRepository playlistRepository;

    public Playlist addPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public Playlist getPlaylistById(Long id) {
        Optional<Playlist> optionalPlaylist = playlistRepository.findById(id);
        return optionalPlaylist.orElse(null);
    }

    public Playlist updatePlaylist(Long id, Playlist playlist) {
        Optional<Playlist> optionalPlaylist = playlistRepository.findById(id);
        if (optionalPlaylist.isPresent()) {
            Playlist existingPlaylist = optionalPlaylist.get();
            existingPlaylist.setName(playlist.getName());
            existingPlaylist.setSongs(playlist.getSongs());
            existingPlaylist.setUser(playlist.getUser());
            return playlistRepository.save(existingPlaylist);
        } else {
            return null;
        }
    }

    public boolean deletePlaylist(Long id) {
        Optional<Playlist> optionalPlaylist = playlistRepository.findById(id);
        if (optionalPlaylist.isPresent()) {
            playlistRepository.delete(optionalPlaylist.get());
            return true;
        } else {
            return false;
        }
    }
}