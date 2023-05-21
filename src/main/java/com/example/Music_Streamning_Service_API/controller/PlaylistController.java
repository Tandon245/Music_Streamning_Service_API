package com.example.Music_Streamning_Service_API.controller;

import com.example.Music_Streamning_Service_API.model.Playlist;
import com.example.Music_Streamning_Service_API.service.PlaylistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @PostMapping("/")
    @PreAuthorize("hasRole('USER_ROLE')")
    public ResponseEntity<?> addPlaylist(@Valid @RequestBody Playlist playlist) {
        Playlist newPlaylist = playlistService.addPlaylist(playlist);
        return ResponseEntity.ok(newPlaylist);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllPlaylists() {
        List<Playlist> playlists = playlistService.getAllPlaylists();
        return ResponseEntity.ok(playlists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlaylistById(@PathVariable Long id) {
        Playlist playlist = playlistService.getPlaylistById(id);
        if (playlist != null) {
            return ResponseEntity.ok(playlist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER_ROLE')")
    public ResponseEntity<?> updatePlaylist(@PathVariable Long id, @Valid @RequestBody Playlist playlist) {
        Playlist updatedPlaylist = playlistService.updatePlaylist(id, playlist);
        if (updatedPlaylist != null) {
            return ResponseEntity.ok(updatedPlaylist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER_ROLE')")
    public ResponseEntity<?> deletePlaylist(@PathVariable Long id) {
        boolean deleted = playlistService.deletePlaylist(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}