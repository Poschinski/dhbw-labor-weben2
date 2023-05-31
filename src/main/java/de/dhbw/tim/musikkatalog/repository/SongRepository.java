package de.dhbw.tim.musikkatalog.repository;

import de.dhbw.tim.musikkatalog.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {


}
