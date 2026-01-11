import client from './client';

export const getAllMovies = () => {
  return client.get('/Movies/AllMovies');
};

export const getMoviesByGenre = (genreName) => {
  return client.get(`/Movies/${genreName}`);
};

export const addMovie = (genreName, movieData) => {
  return client.post(`/Movies/add/${genreName}`, movieData);
};
