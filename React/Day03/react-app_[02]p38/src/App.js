// import logo from './logo.svg';
import './App.css';
import { Component } from 'react';
import { Subject } from './Subject';
import { TOC } from './TOC';
import { Content } from './Content';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      subject: { title: 'WEB', sub: 'World Wide Web!' },
      contents: [
        {id: 1, title: 'HTML2', desc: 'HTML is for information.'},
        {id: 2, title: 'CSS2', desc: 'CSS is for design.'},
        {id: 3, title: 'JavaScript2', desc: 'JavaScript is for interactive.'}
      ],
      mode: 'welcome',  // html
      welcome: {title: 'welcome', desc: 'Hello, React'}
    }
  }
  render() {
    let title, desc;
    if(this.state.mode == 'welcome') {
      title = this.state.welcome.title;
      desc = this.state.welcome.desc;
    } else if(this.state.mode == 'html') {
      title = this.state.contents[0].title;
      desc = this.state.contents[0].desc;
    }

    if(this.state.mode == 'welcome') {
      title = this.state.welcome.title;
      desc = this.state.welcome.desc;
    } else if(this.state.mode == 'css') {
      title = this.state.contents[1].title;
      desc = this.state.contents[1].desc;
    }

    if(this.state.mode == 'welcome') {
      title = this.state.welcome.title;
      desc = this.state.welcome.desc;
    } else if(this.state.mode == 'javascript') {
      title = this.state.contents[2].title;
      desc = this.state.contents[2].desc;
    }

    return (   // JSX
      <div className="App">
        <Subject
        title={this.state.subject.title} 
        sub={this.state.subject.sub}></Subject>

        <TOC onChangePage={
          (value) => { this.setState({mode: value}) }

        } contents={this.state.contents}></TOC>
        <Content title={title} desc={desc}></Content>
      </div>
    );
  }
}


export default App;
