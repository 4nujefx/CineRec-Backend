import { useState, useEffect } from 'react';
import { getGenres } from '../api/genres';
import { getAllMovies, getMoviesByGenre } from '../api/movies';
import { useAuth } from '../context/AuthContext';
import MovieList from '../components/MovieList';
import GenreList from '../components/GenreList';
import Navigation from '../components/Navigation';
import '../styles/Home.css';

export default function Home() {
  const [genres, setGenres] = useState([]);
  const [movies, setMovies] = useState([]);
  const [selectedGenre, setSelectedGenre] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');
  const { isLoggedIn } = useAuth();

  useEffect(() => {
    fetchGenres();
  }, []);

  useEffect(() => {
    if (isLoggedIn) {
      if (selectedGenre) {
        fetchMoviesByGenre(selectedGenre);
      } else {
        fetchAllMovies();
      }
    }
  }, [selectedGenre, isLoggedIn]);

  const fetchGenres = async () => {
    try {
      setLoading(true);
      const response = await getGenres();
      setGenres(response.data);
      setError('');
    } catch (err) {
      setError('Failed to load genres');
    } finally {
      setLoading(false);
    }
  };

  const fetchAllMovies = async () => {
    try {
      setLoading(true);
      const response = await getAllMovies();
      setMovies(response.data);
      setError('');
    } catch (err) {
      setError('Failed to load movies');
    } finally {
      setLoading(false);
    }
  };

  const fetchMoviesByGenre = async (genreName) => {
    try {
      setLoading(true);
      const response = await getMoviesByGenre(genreName);
      setMovies(response.data);
      setError('');
    } catch (err) {
      setError('Failed to load movies for this genre');
    } finally {
      setLoading(false);
    }
  };

  const handleClearFilter = () => {
    setSelectedGenre(null);
  };

  if (!isLoggedIn) {
    return (
      <div className="not-logged-in">
        <h1>CineRec</h1>
        <p>Please sign up to explore movies and genres</p>
      </div>
    );
  }

  return (
    <div className="home-container">
      <Navigation />

      <div className="main-content">
        <div className="sidebar">
          <GenreList
            genres={genres}
            selectedGenre={selectedGenre}
            onSelectGenre={setSelectedGenre}
            onClearFilter={handleClearFilter}
          />
        </div>

        <div className="content">
          <div className="header">
            <h1>Movies</h1>
            {selectedGenre && (
              <div className="filter-tag">
                Showing: <strong>{selectedGenre}</strong>
                <button onClick={handleClearFilter} className="clear-btn">×</button>
              </div>
            )}
          </div>

          {error && <div className="error-message">{error}</div>}
          {loading && <div className="loading">Loading movies...</div>}

          <MovieList movies={movies} />
        </div>
      </div>
    </div>
  );
}
