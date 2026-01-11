import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080';

const client = axios.create({
  baseURL: API_BASE_URL,
  timeout: 10000,
});

client.interceptors.request.use((config) => {
  const credentials = localStorage.getItem('auth_credentials');
  if (credentials) {
    const [username, password] = Buffer.from(credentials, 'base64').toString().split(':');
    const encoded = Buffer.from(`${username}:${password}`).toString('base64');
    config.headers.Authorization = `Basic ${encoded}`;
  }
  return config;
});

export default client;
