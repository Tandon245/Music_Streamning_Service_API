package com.example.Music_Streamning_Service_API.repository;

import com.example.Music_Streamning_Service_API.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends JpaRepository<Song,Long> {
}
