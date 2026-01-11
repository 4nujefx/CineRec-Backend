import { useNavigate } from 'react-router-dom';
import { logout } from '../api/auth';
import { useAuth } from '../context/AuthContext';
import '../styles/Navigation.css';

export default function Navigation() {
  const { username, logout: authLogout } = useAuth();
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    authLogout();
    navigate('/signup');
  };

  return (
    <nav className="navbar">
      <div className="nav-container">
        <div className="nav-brand">
          <h1>CineRec</h1>
        </div>

        <div className="nav-user">
          <span className="username">Welcome, {username}</span>
          <button onClick={handleLogout} className="logout-btn">Logout</button>
        </div>
      </div>
    </nav>
  );
}
