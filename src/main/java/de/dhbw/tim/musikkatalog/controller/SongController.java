package de.dhbw.tim.musikkatalog.controller;

import de.dhbw.tim.musikkatalog.model.Song;
import de.dhbw.tim.musikkatalog.repository.SongRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SongController {

    //private List<Song> Songs = new ArrayList<Song>();
    private SongRepository songRepository;

    public SongController(SongRepository songRepository) { this.songRepository = songRepository;}

    @GetMapping("/songs")
    public ResponseEntity<List<Song>> getAllSongs(@RequestParam(required = false) String title) {

        try {
            List<Song> posts = new ArrayList<Song>();

            if (title == null) {
                posts.addAll(songRepository.findAll());
            } else {
                posts.addAll(songRepository.findByTitleContaining(title));
            }

            if(posts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(posts, HttpStatus.OK);

        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/songs/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable("id") long id) {

        Optional<Song> postData =  songRepository.findById(id);

        if(postData.isPresent()) {
            return new ResponseEntity<>(postData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/songs")
    public ResponseEntity<Song> createSong(@RequestBody Song song) {

        try {

            Song _song = songRepository
                    .save(new Song(song.getTitle(), song.getAlbum(), song.getArtist(), song.getGenre(), song.getReleaseDate(), song.getRecordingMedium(), song.getFileName()));

            return new ResponseEntity<>(_song, HttpStatus.CREATED);

        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
