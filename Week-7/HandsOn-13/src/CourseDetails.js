import React from 'react';

function CourseDetails() {
  const courses = [
    { id: 1, name: "React Development", duration: "6 weeks" },
    { id: 2, name: "Node.js Mastery", duration: "4 weeks" },
    { id: 3, name: "Full-Stack Bootcamp", duration: "8 weeks" }
  ];

  return (
    <div>
      <h2>🎓 Course Details</h2>
      <ul>
        {courses.map(course => (
          <li key={course.id}>
            {course.name} – {course.duration}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CourseDetails;
