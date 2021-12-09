import React, { Component } from 'react';
class CreateContent extends Component {
  render() {
    return (
      <article>
        <h2>Create Content</h2>
        <form action='/create_process' 
              method='post' onSubmit={function(e) {
                e.preventDefault();
                const title = e.target.title.value;
                const desc = e.target.desc.value;
                this.props.onSubmit(title, desc);
              }.bind(this)}>

          <p><input type='text' name='title'></input></p>
          <p><textarea name='desc'></textarea></p>
          <p><input type='submit'></input></p>
        </form>
      </article>
    )
  }
}
export default CreateContent;