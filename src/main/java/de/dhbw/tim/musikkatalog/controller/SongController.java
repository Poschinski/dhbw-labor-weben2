package de.dhbw.tim.musikkatalog.controller;

import de.dhbw.tim.musikkatalog.model.Song;
import de.dhbw.tim.musikkatalog.repository.SongRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SongController {

    private final SongRepository songRepository;

    public SongController(SongRepository songRepository) { this.songRepository = songRepository;}

    @GetMapping("/songs")
    public ResponseEntity<List<Song>> getAllSongs(@RequestParam(required = false) String title) {

        try {
            List<Song> posts = new ArrayList<>();

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
        Optional<Song> song = this.findSongInLocalList(id);

        if (song.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            songRepository.delete(song.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/songs/{id}")
    public ResponseEntity<Song> updateSongs(@PathVariable("id") long id, @RequestBody Song song) {
        Optional<Song> currentSong = this.findSongInLocalList(id);
        if (currentSong.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            songRepository.delete(currentSong.get());
            currentSong.get().setAlbum(song.getAlbum());
            currentSong.get().setGenre(song.getGenre());
            currentSong.get().setArtist(song.getArtist());
            currentSong.get().setTitle(song.getTitle());
            currentSong.get().setFileName(song.getFileName());
            currentSong.get().setRecordingMedium(song.getRecordingMedium());
            currentSong.get().setReleaseDate(song.getReleaseDate());
            songRepository.save((currentSong.get()));
            return new ResponseEntity<>(currentSong.get(), HttpStatus.OK);
        }
    }

    private Optional<Song> findSongInLocalList(long id) {
        return songRepository.findById(id);
    }
}
















