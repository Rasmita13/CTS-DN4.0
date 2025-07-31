import React, { useState } from 'react';
import GuestPage from './GuestPage';
import UserPage from './UserPage';
function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const loginUser = () => setIsLoggedIn(true);
  const logoutUser = () => setIsLoggedIn(false);

  return (
    <div style={{ textAlign: 'center', fontFamily: 'Arial', marginTop: '30px' }}>
      <h1>🎟️ Ticket Booking App</h1>
      {isLoggedIn ? (
        <button onClick={logoutUser} style={{ marginBottom: '15px' }}>Logout</button>
      ) : (
        <button onClick={loginUser} style={{ marginBottom: '15px' }}>Login</button>
      )}

      <hr style={{ width: '50%', margin: '20px auto' }} />
{/* ✅ Conditional Rendering of Pages */}
      {isLoggedIn ? <UserPage /> : <GuestPage />}
    </div>
  );
}

export default App;
