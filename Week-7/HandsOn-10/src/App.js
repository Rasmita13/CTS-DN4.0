import React from 'react';
import officeImg from './images/pexels-photo-380769.jpeg';  // ✅ Import here

function App() {
  // Creating an object for one office
  const office = {
    name: "Tech Park - Block A",
    rent: 55000,
    address: "MG Road, Bengaluru"
  };

  // Creating a list of offices
  const offices = [
    { name: "Tech Park - Block A", rent: 55000, address: "MG Road, Bengaluru" },
    { name: "Skyline Towers", rent: 75000, address: "Banjara Hills, Hyderabad" },
    { name: "Business Hub", rent: 62000, address: "Andheri, Mumbai" },
    { name: "StartUp Space", rent: 45000, address: "Sector 62, Noida" }
  ];

  // Inline styling for image
  const imgStyle = {
    width: "200px",
    height: "150px",
    borderRadius: "5px",
    marginBottom: "5px"
  };

  return (
    <div style={{ textAlign: "center", fontFamily: "Arial" }}>
      <h1>🏢 Office Space Rental App</h1>
      <img src={officeImg} alt="Office Space" style={imgStyle} />

      
      <h2>Featured Office</h2>
      <p><strong>Name:</strong> {office.name}</p>
      <p><strong>Rent:</strong> ₹
        <span style={{ color: office.rent < 60000 ? "red" : "green" }}>
          {office.rent}
        </span>
      </p>
      <p><strong>Address:</strong> {office.address}</p>

      <hr />

      
      <h2>Available Office Spaces</h2>
      <ul style={{ listStyle: "none", padding: 0 }}>
        {offices.map((o, index) => (
          <li key={index} style={{ marginBottom: "20px" }}>
            <strong>{o.name}</strong> - ₹
            <span style={{ color: o.rent < 60000 ? "red" : "green" }}>
              {o.rent}
            </span>
            <br />
            <small>{o.address}</small>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
