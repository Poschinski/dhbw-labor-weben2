// Funktion zum Hinzufügen eines neuen Songs
function addSong(event) {
    event.preventDefault();

    const form = document.getElementById('songForm');
    const title = form.elements.title.value;
    const album = form.elements.album.value;
    const artist = form.elements.artist.value;
    const genre = form.elements.genre.value;
    const releaseDate = form.elements.releaseDate.value;
    const medium = form.elements.medium.value;
    const filename = form.elements.filename.value;

    const song = {
      title,
      album,
      artist,
      genre,
      releaseDate,
      medium,
      filename
    };

    // API-Aufruf zum Speichern des Songs
    fetch('/api/songs', {
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
    fetch('/api/songs')
    .then(response => response.json())
    .then(data => {
      const songList = document.getElementById('songList');
      songList.innerHTML = '';

      // Songs zur Liste hinzufügen
      data.forEach(song => {
        const listItem = document.createElement('li');
        listItem.textContent = song.title;

        listItem.addEventListener('click', () => {
          // Song auswählen und Daten im Formular anzeigen
          document.getElementById('title').value = song.title;
          document.getElementById('album').value = song.album;
          document.getElementById('artist').value = song.artist;
          document.getElementById('genre').value = song.genre;
          document.getElementById('releaseDate').value = song.releaseDate;
          document.getElementById('medium').value = song.medium;
          document.getElementById('filename').value = song.filename;
        });

        songList.appendChild(listItem);
      });
    })
    .catch(error => console.error(error));
  }

  // Event Listener für das Absenden des Formulars
  const songForm = document.getElementById('songForm');
  songForm.addEventListener('submit', addSong);

  // Beim Laden der Seite Songs laden
  loadSongs();