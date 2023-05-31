package de.dhbw.tim.musikkatalog.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "musiktitel")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String album;
    private String artist;
    private String genre;
    private LocalDate releaseDate;
    private String recordingMedium;
    private String fileName;

    public Song() {}

    public Song(String title, String album, String artist, String genre, LocalDate releaseDate, String recordingMedium, String fileName) {
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.recordingMedium = recordingMedium;
        this.fileName = fileName;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRecordingMedium() {
        return recordingMedium;
    }

    public void setRecordingMedium(String recordingMedium) {
        this.recordingMedium = recordingMedium;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}