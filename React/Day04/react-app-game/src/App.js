import React, { Component } from 'react';
import './App.css';
import Title from './components/Title';
import Result from './components/Result';
import Scissors from './components/Scissors';
import Rock from './components/Rock';
import Paper from './components/Paper';


class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      user: '-', com: '-', result: '선택해주세요'

    }
  }


  render() {

    this.state.com = parseInt(Math.random() * 3);

    if (this.state.you != '-')
      if ((this.state.you + 1) % 3 == this.state.com) {
        // 사람이 졌음
        this.state.result = '당신이 졌습니다.'
      } else if (this.state.you == this.state.com) {
        this.state.result = '비겼습니다'

      } else {
        this.state.result = '당신이 이겼습니다'
      }


    return (
      <div className="main">
        <Title />
        <Scissors onSubmit={(num) => {
          this.setState({ you: num });
        }} />
        <Rock onSubmit={(num) => {
          this.setState({ you: num });
        }} />
        <Paper onSubmit={(num) => {
          this.setState({ you: num });
        }} />
        <Result result={this.state.result} />

      </div>
    );
  }
}





export default App;
