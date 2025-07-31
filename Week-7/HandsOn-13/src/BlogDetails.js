import React from 'react';

function BlogDetails() {
  const blogs = [
    { id: 1, title: "React Tips", date: "2025-07-29" },
    { id: 2, title: "JavaScript Trends", date: "2025-07-20" },
    { id: 3, title: "CSS Tricks", date: "2025-07-10" }
  ];

  return (
    <div>
      <h2>📝 Blog Details</h2>
      <ul>
        {blogs.map(blog => (
          <li key={blog.id}>
            {blog.title} – <em>{blog.date}</em>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BlogDetails;
