import client from './client';

export const getGenres = () => {
  return client.get('/Genre/genres');
};

export const addGenre = (name) => {
  return client.post('/Genre/add/Genre', { name });
};
