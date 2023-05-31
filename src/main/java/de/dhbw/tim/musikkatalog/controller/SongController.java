package de.dhbw.tim.musikkatalog.controller;

import de.dhbw.tim.musikkatalog.model.Song;
import de.dhbw.tim.musikkatalog.repository.SongRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SongController {

    //private List<Song> Songs = new ArrayList<Song>();
    private SongRepository songRepository;

    public SongController(SongRepository songRepository) { this.songRepository = songRepository;}

    @GetMapping("/songs")
    public ResponseEntity<List<Song>> getAllSongs() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/songs({id}")
    public ResponseEntity<Song> getSongById(@PathVariable("id") long id) {
        return null;
    }

    @PostMapping("/songs")
    public ResponseEntity<Song> createSong(@RequestBody Song song) {
        return null;
    }

    @DeleteMapping("/songs/{id}")
    public ResponseEntity<HttpStatus> deleteSong(@PathVariable("id") long id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testResponse() {
        return new ResponseEntity<>("Helo", HttpStatus.OK);
    }

}
