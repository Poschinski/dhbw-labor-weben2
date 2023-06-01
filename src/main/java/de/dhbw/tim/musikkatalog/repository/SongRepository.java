package de.dhbw.tim.musikkatalog.repository;

import de.dhbw.tim.musikkatalog.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findByTitleContaining(String title);
}
