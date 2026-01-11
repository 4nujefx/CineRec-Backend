import client from './client';

export const signup = (username, password) => {
  const credentials = Buffer.from(`${username}:${password}`).toString('base64');
  return client.post('/USER/user', { username, password }, {
    headers: {
      Authorization: `Basic ${credentials}`,
    },
  });
};

export const login = (username, password) => {
  const credentials = Buffer.from(`${username}:${password}`).toString('base64');
  localStorage.setItem('auth_credentials', credentials);
  localStorage.setItem('username', username);
  return Promise.resolve({ username });
};

export const logout = () => {
  localStorage.removeItem('auth_credentials');
  localStorage.removeItem('username');
};

export const getCurrentUser = () => {
  return localStorage.getItem('username');
};

export const isLoggedIn = () => {
  return localStorage.getItem('auth_credentials') !== null;
};
