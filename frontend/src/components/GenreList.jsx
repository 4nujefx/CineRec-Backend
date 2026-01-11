import '../styles/GenreList.css';

export default function GenreList({ genres, selectedGenre, onSelectGenre, onClearFilter }) {
  return (
    <div className="genres-container">
      <h2>Genres</h2>
      <button
        onClick={onClearFilter}
        className={`genre-btn all-genres ${!selectedGenre ? 'active' : ''}`}
      >
        All Genres
      </button>

      <div className="genres-list">
        {genres && genres.length > 0 ? (
          genres.map((genre) => (
            <button
              key={genre.genre_id}
              onClick={() => onSelectGenre(genre.name)}
              className={`genre-btn ${selectedGenre === genre.name ? 'active' : ''}`}
            >
              {genre.name}
            </button>
          ))
        ) : (
          <p className="no-genres">No genres available</p>
        )}
      </div>
    </div>
  );
}
