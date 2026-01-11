import '../styles/MovieList.css';

export default function MovieList({ movies }) {
  if (!movies || movies.length === 0) {
    return <div className="no-movies">No movies found</div>;
  }

  return (
    <div className="movies-grid">
      {movies.map((movie) => (
        <div key={movie.movie_id} className="movie-card">
          <div className="movie-poster">
            <div className="poster-placeholder">{movie.title?.charAt(0) || 'M'}</div>
          </div>
          <div className="movie-info">
            <h3>{movie.title}</h3>
            {movie.genre && <p className="genre">{movie.genre}</p>}
            {movie.release_year && <p className="year">Year: {movie.release_year}</p>}
            {movie.rating && <p className="rating">Rating: {movie.rating}/10</p>}
          </div>
        </div>
      ))}
    </div>
  );
}
