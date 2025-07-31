import React, { useState } from 'react';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  const [count, setCount] = useState(0);
  
  const increment = () => {
    setCount(count + 1);
    sayHello(); 
  };

  
  const decrement = () => {
    setCount(count - 1);
  };

  const sayHello = () => {
    alert("Hello! 👋 Keep clicking the button!");
  };
  const sayWelcome = (msg) => {
    alert(msg);
  };
  const handleSyntheticEvent = (event) => {
    alert("I was clicked");
    console.log("Synthetic Event Object:", event); 
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '30px', fontFamily: 'Arial' }}>
      <h1>🎯 Event Examples App</h1>

      
      <h2>Counter: {count}</h2>
      <button onClick={increment} style={{ margin: '5px' }}>Increment</button>
      <button onClick={decrement} style={{ margin: '5px' }}>Decrement</button>

      <hr />

      
      <button onClick={() => sayWelcome("Welcome to the React Event Lab!")} style={{ margin: '5px' }}>
        Say Welcome
      </button>

      <hr />

      
      <button onClick={handleSyntheticEvent} style={{ margin: '5px' }}>
        Synthetic Event Button
      </button>

      <hr />

      
      <CurrencyConvertor />
    </div>
  );
}

export default App;
