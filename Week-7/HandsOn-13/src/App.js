import React, { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

function App() {
  const [view, setView] = useState("books"); 
  const renderContent = () => {
    if (view === "books") {
      return <BookDetails />;
    } else if (view === "blogs") {
      return <BlogDetails />;
    } else {
      return <CourseDetails />;
    }
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '20px', fontFamily: 'Arial' }}>
      <h1>📖 Blogger App</h1>
      <div style={{ marginBottom: '20px' }}>
        <button onClick={() => setView("books")} style={{ margin: '5px' }}>Show Books</button>
        <button onClick={() => setView("blogs")} style={{ margin: '5px' }}>Show Blogs</button>
        <button onClick={() => setView("courses")} style={{ margin: '5px' }}>Show Courses</button>
      </div>

      <hr style={{ width: '50%', margin: '20px auto' }} />
      {renderContent()}
      <div style={{ marginTop: '20px' }}>
        {view === "books"
          ? <p>📚 You are viewing Book Details</p>
          : view === "blogs"
          ? <p>📝 You are viewing Blog Details</p>
          : <p>🎓 You are viewing Course Details</p>}
      </div>
      {view === "books" && <p style={{ color: 'green' }}>✔ Books section is active</p>}
    </div>
  );
}

export default App;
