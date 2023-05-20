package de.dhbw.tim.musikkatalog.controller;

import de.dhbw.tim.musikkatalog.model.Musiktitel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MusiktitelController {

    @GetMapping("/songs")
    public ResponseEntity<Musiktitel> getAllSongs() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testResponse() {
        return new ResponseEntity<>("Helo", HttpStatus.OK);
    }

}
