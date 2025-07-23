import React, { Component } from 'react';
import Post from './Post';
class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        if (!response.ok) throw new Error("Failed to fetch posts");
        return response.json();
      })
      .then(data => {
        const postList = data.map(p => new Post(p.userId, p.id, p.title, p.body));
        this.setState({ posts: postList });
      })
      .catch(error => {
        this.setState({ hasError: true });
        console.error("Error fetching posts:", error);
      });
  }

  
  componentDidMount() {
    this.loadPosts();
  }


  componentDidCatch(error, info) {
    alert("An error occurred: " + error);
    console.log("Error info:", info);
    this.setState({ hasError: true });
  }

  // Step 8: render posts
  render() {
    if (this.state.hasError) {
      return <h2>Something went wrong while loading posts.</h2>;
    }

    return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.map(post => (
          <div key={post.id} style={{ border: "1px solid #ccc", padding: "10px", margin: "10px" }}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
