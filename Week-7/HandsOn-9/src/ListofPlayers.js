import React from 'react';
const ListofPlayers = () => {
  // Step 1: Declare array with 11 players and scores
  const players = [
    { name: 'Virat Kohli', score: 95 },
    { name: 'Rohit Sharma', score: 88 },
    { name: 'Shubman Gill', score: 65 },
    { name: 'KL Rahul', score: 72 },
    { name: 'Suryakumar Yadav', score: 55 },
    { name: 'Ravindra Jadeja', score: 78 },
    { name: 'Hardik Pandya', score: 60 },
    { name: 'R Ashwin', score: 74 },
    { name: 'Jasprit Bumrah', score: 68 },
    { name: 'Mohammed Shami', score: 50 },
    { name: 'Kuldeep Yadav', score: 80 }
  ];
 // Step 2: Use map() to display players and scores
  const playerList = players.map((p, index) => (
    <li key={index}>{p.name} - {p.score}</li>
  ));

  // Step 3: Use arrow function to filter players with score < 70
  const lowScorers = players.filter(p => p.score < 70);

  return (
    <div>
      <h2>All Players:</h2>
      <ul>{playerList}</ul>

      <h2>Players with Score Below 70:</h2>
      <ul>
        {lowScorers.map((p, index) => (
          <li key={index}>{p.name} - {p.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
