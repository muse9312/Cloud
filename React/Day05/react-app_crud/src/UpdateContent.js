import React, { Component } from 'react';
class UpdateContent extends Component {
  constructor(props) {  // 규칙, 공식 외워야 되는 내용
    super(props);       // <== 여기까지 공식
    this.state = {
      title: this.props.title,
      desc: this.props.desc
    };
  }
  render() {
    return (
      <article>
        <h2>Update Content</h2>
        <form action='/update_process' method='post'>

          <p><input type='text' name='title'
            value={this.state.title} onChange={( e ) => {
              // 나 <- UpdateContent
              this.setState({title: e.target.value});
            }}></input></p>


          <p><textarea name='desc'
            value={this.props.desc}></textarea></p>
          <p><input type='submit'></input></p>
        </form>
      </article>
    )
  }
}
export default UpdateContent;