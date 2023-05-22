package de.dhbw.tim.musikkatalog.controller;

import de.dhbw.tim.musikkatalog.model.Musiktitel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MusiktitelController {

    @GetMapping("/songs")
    public ResponseEntity<List<Musiktitel>> getAllSongs() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/songs({id}")
    public ResponseEntity<Musiktitel> getSongById(@PathVariable("id") long id) {
        return null;
    }

    @PostMapping("/songs")
    public ResponseEntity<Musiktitel> createSong(@RequestBody Musiktitel song) {
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
