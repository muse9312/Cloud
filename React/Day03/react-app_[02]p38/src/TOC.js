import { Component } from 'react';

class TOC extends Component {
  constructor(props) {
    super(props);


    this.state = {

    }
  }
  render() {

    let list = [];

    for (let i = 0; i < this.props.contents.length; i++) {

      list.push(<li><a href={this.props.contents[i].id + '.html'}
        onClick={(e) => {
          this.props.onChangePage
            (this.props.contents[i].id);
          e.preventDefault();
        }}
      >
        {this.props.contents[i].title}</a></li>)

    }

    return (
      <nav>

        <ul>{list}</ul>

      </nav>
    );
  }
}

export { TOC };