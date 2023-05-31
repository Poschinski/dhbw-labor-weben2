package de.dhbw.tim.musikkatalog.controller;

import de.dhbw.tim.musikkatalog.model.Song;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SongController {

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
