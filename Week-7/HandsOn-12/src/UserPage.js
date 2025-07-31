import React, { useState } from 'react';
function UserPage() {
  const [selectedFlight, setSelectedFlight] = useState('');
  const [message, setMessage] = useState('');
  const handleBooking = (e) => {
    e.preventDefault();
    if (selectedFlight) {
      setMessage(`✅ Ticket booked successfully for: ${selectedFlight}`);
    } else {
      setMessage('⚠️ Please select a flight before booking.');
    }
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '20px' }}>
      <h2>✅ Welcome Back! Book Your Ticket</h2>

      <form onSubmit={handleBooking}>
        <label>
          Choose a flight:
          <select
            value={selectedFlight}
            onChange={(e) => setSelectedFlight(e.target.value)}
            style={{ margin: '10px' }}
          >
            <option value="">-- Select --</option>
            <option>Bengaluru ➡️ Delhi – ₹4500</option>
            <option>Hyderabad ➡️ Mumbai – ₹3800</option>
            <option>Chennai ➡️ Goa – ₹5000</option>
          </select>
        </label>
        <br />
        <button type="submit" style={{ marginTop: '10px' }}>Book Ticket</button>
      </form>

      {message && <p style={{ marginTop: '15px', fontWeight: 'bold' }}>{message}</p>}
    </div>
  );
}

export default UserPage;
