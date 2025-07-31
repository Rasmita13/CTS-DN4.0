import React from 'react';
function BookDetails() {
  const books = [
    { id: 1, title: "React Basics", author: "Dan Abramov" },
    { id: 2, title: "JavaScript Mastery", author: "Kyle Simpson" },
    { id: 3, title: "Learning ES6", author: "Nicholas Zakas" }
  ];

  return (
    <div>
      <h2>📚 Book Details</h2>
      <ul>
        {books.map(book => (
          <li key={book.id}>
            <strong>{book.title}</strong> – {book.author}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BookDetails;
