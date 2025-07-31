import React from 'react';
const IndianPlayers = () => {
  // Step 1: Declare two arrays
  const T20players = ['Virat Kohli', 'Rohit Sharma', 'Suryakumar Yadav'];
  const RanjiTrophyPlayers = ['Cheteshwar Pujara', 'Ajinkya Rahane'];

  // Step 2: Merge arrays using spread operator (ES6)
  const allPlayers = [...T20players, ...RanjiTrophyPlayers];

  // Step 3: Destructure odd/even players
  const oddPlayers = allPlayers.filter((_, index) => index % 2 !== 0);
  const evenPlayers = allPlayers.filter((_, index) => index % 2 === 0);

  return (
    <div>
      <h2>Odd Team Players:</h2>
      <ul>{oddPlayers.map((p, i) => <li key={i}>{p}</li>)}</ul>

      <h2>Even Team Players:</h2>
      <ul>{evenPlayers.map((p, i) => <li key={i}>{p}</li>)}</ul>
    </div>
  );
};

export default IndianPlayers;
