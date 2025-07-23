import React, { useState } from 'react';
import '../Stylesheets/mystyle.css';
function CalculateScore() {
  const [name, setName] = useState('');
  const [school, setSchool] = useState('');
  const [total, setTotal] = useState('');
  const [goal, setGoal] = useState('');
  const [average, setAverage] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    const avg = parseFloat(total) / parseFloat(goal);
    setAverage(avg.toFixed(2));
  };

  return (
    <div className="container">
      <h2>Student Score Calculator</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" placeholder="Enter Name" onChange={(e) => setName(e.target.value)} required />
        <input type="text" placeholder="Enter School" onChange={(e) => setSchool(e.target.value)} required />
        <input type="number" placeholder="Enter Total Marks" onChange={(e) => setTotal(e.target.value)} required />
        <input type="number" placeholder="Enter Goal (Max Marks)" onChange={(e) => setGoal(e.target.value)} required />
        <button type="submit">Calculate</button>
      </form>
      {average && (
        <div className="result">
          <p><strong>Name:</strong> {name}</p>
          <p><strong>School:</strong> {school}</p>
          <p><strong>Average Score:</strong> {average}</p>
        </div>
      )}
    </div>
  );
}

export default CalculateScore;
