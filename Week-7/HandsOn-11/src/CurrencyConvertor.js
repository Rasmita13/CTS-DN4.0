import React, { useState } from 'react';

function CurrencyConvertor() {
  const [rupees, setRupees] = useState('');
  const [euro, setEuro] = useState(null);

  const handleSubmit = (event) => {
    event.preventDefault(); 
    const conversionRate = 0.011; 
    setEuro((rupees * conversionRate).toFixed(2));
  };

  return (
    <div style={{ marginTop: '20px' }}>
      <h2>💱 Currency Convertor</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          placeholder="Enter amount in INR"
          value={rupees}
          onChange={(e) => setRupees(e.target.value)}
          style={{ padding: '5px', marginRight: '10px' }}
        />
        <button type="submit">Convert</button>
      </form>

      {euro !== null && (
        <h3>{rupees} INR = {euro} EUR</h3>
      )}
    </div>
  );
}

export default CurrencyConvertor;
