import React from 'react';
function GuestPage() {
  return (
    <div style={{ textAlign: 'center', marginTop: '20px' }}>
      <h2>✈️ Flight Information</h2>
      <p>Browse available flights, but you must log in to book tickets.</p>

      <h3>Available Flights</h3>
      <ul style={{ listStyle: 'none', padding: 0 }}>
        <li>🔵 Bengaluru ➡️ Delhi – ₹4500</li>
        <li>🔵 Hyderabad ➡️ Mumbai – ₹3800</li>
        <li>🔵 Chennai ➡️ Goa – ₹5000</li>
      </ul>
    </div>
  );
}

export default GuestPage;
