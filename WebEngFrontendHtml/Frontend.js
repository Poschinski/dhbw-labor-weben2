const defaultUrl = "http://localhost:8080"

var selectedSong = null;

// Funktion zum Hinzufügen eines neuen Songs
function addSong(event) {
    event.preventDefault();

    const form = document.getElementById('songForm');
    song = getFormularData();

    // API-Aufruf zum Speichern des Songs
    fetch(defaultUrl +'/api/songs', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(song)
    })
    .then(response => response.json())
    .then(data => {
      // Aufruf zum Laden der aktualisierten Songliste
      loadSongs();
    })
    .catch(error => console.error(error));

    // Formular zurücksetzen
    form.reset();
  }

  // Funktion zum Laden der Songs
  function loadSongs() {

    // API-Aufruf zum Laden der Songs
    fetch(defaultUrl + '/api/songs')
    .then(response => response.json())
    .then(data => {
      createTable(data)
    })
    .catch(error => console.error(error));
  }

  // Funktion zum Erstellen der Tabelle
  function createTable(songs) {
    var table = document.getElementById('songTable');
    var tbody = table.querySelector('tbody');

    // Vorhandene Tabellenzeilen entfernen
    tbody.innerHTML = '';

    // JSON-Daten durchlaufen und Tabellenzeilen erstellen
    songs.forEach(function(song) {
      var row = document.createElement('tr');
      
      // Tabellenzellen erstellen und Daten einfügen
      var idCell = document.createElement('td');
      idCell.textContent = song.id;
      row.appendChild(idCell);

      var titleCell = document.createElement('td');
      titleCell.textContent = song.title;
      row.appendChild(titleCell);

      var albumCell = document.createElement('td');
      albumCell.textContent = song.album;
      row.appendChild(albumCell);

      var artistCell = document.createElement('td');
      artistCell.textContent = song.artist;
      row.appendChild(artistCell);

      var genreCell = document.createElement('td');
      genreCell.textContent = song.genre;
      row.appendChild(genreCell);

      var releaseDateCell = document.createElement('td');
      releaseDateCell.textContent = song.releaseDate;
      row.appendChild(releaseDateCell);

      var recordingMediumCell = document.createElement('td');
      recordingMediumCell.textContent = song.recordingMedium;
      row.appendChild(recordingMediumCell);

      var fileNameCell = document.createElement('td');
      fileNameCell.textContent = song.fileName;
      row.appendChild(fileNameCell);

      // Reihe anklickbar machen und hervorheben
      row.addEventListener('click', function() {
      var selectedRow = document.querySelector('.selected');
      if (selectedRow) {
        selectedRow.classList.remove('selected');
      }
      row.classList.add('selected');

      // Buttons "Löschen" und "Update" anzeigen
      var deleteButton = document.getElementById('deleteButton');
      var updateButton = document.getElementById('updateButton');
      deleteButton.style.display = 'inline-block';
      updateButton.style.display = 'inline-block';

      // Daten im Formular anzeigen
      document.getElementById('title').value = song.title;
      document.getElementById('album').value = song.album;
      document.getElementById('artist').value = song.artist;
      document.getElementById('genre').value = song.genre;
      document.getElementById('releaseDate').value = song.releaseDate;
      document.getElementById('medium').value = song.recordingMedium;
      document.getElementById('filename').value = song.fileName;

      // Daten speichern
      selectedSong = {
        id: song.id,
        title: song.title,
        album: song.album,
        artist: song.artist,
        genre: song.genre,
        releaseDate: song.releaseDate,
        recordingMedium: song.recordingMedium,
        fileName: song.fileName
      };
    });

      // Tabellenzeile zur Tabelle hinzufügen
      tbody.appendChild(row);
    });
  }

  function deleteSong() {
    var songId = selectedSong.id;

    return fetch(defaultUrl + '/api/songs/' + songId, {
      method: 'Delete'
    })
    .then(data => {
      // Aufruf zum Laden der aktualisierten Songliste
      loadSongs();
    })
    .catch(error => console.error(error));
  }

  function updateSong() {
    var songId = selectedSong.id;
    song = getFormularData();

    return fetch(defaultUrl + '/api/songs/' + songId, {
      method: 'Put',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(song)
    })
    .then(response => response.json())
    .then(data => {
      // Aufruf zum Laden der aktualisierten Songliste
      loadSongs();
    })
    .catch(error => console.error(error));
  }

  function getFormularData() {
    const form = document.getElementById('songForm');

    const title = form.elements.title.value;
    const album = form.elements.album.value;
    const artist = form.elements.artist.value;
    const genre = form.elements.genre.value;
    const releaseDate = form.elements.releaseDate.value;
    const medium = form.elements.medium.value;
    const filename = form.elements.filename.value;

    return {
      title: title,
      album: album,
      artist: artist,
      genre: genre,
      releaseDate: releaseDate,
      recordingMedium: medium,
      fileName: filename
    };
  }
  // Event Listener für das Absenden des Formulars
  const songForm = document.getElementById('songForm');

  songForm.addEventListener('submit', addSong);

  // Beim Laden der Seite Songs laden
  loadSongs();