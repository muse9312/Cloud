/* eslint-disable */

import logo from './logo.svg';
import './App.css';
import { Component, useState } from 'react';

// 단축키 Ctrl + P : 파일 열기

class ClassComp extends Component {
  constructor(props) {
    super(props);
    this.state = {
      initNumber: this.props.initNumber,  // 2
      date: new Date().toString()
    }

    console.log('class Comp => constructor');
  }
  componentDidMount() {
    console.log('class Comp => componentDidMount');
  }

  shouldComponentUpdate(newxtProps, nextState) {
    console.log('class Comp => shouldComponentUpdate');
  }

  componentDidUpdate(newxtProps, nextState) {
    console.log('class Comp => componentDidUpdate');
  }

  componentWillUnmount() {
    console.log('class Comp => componentWillUnmount');
  }

  render() {
    console.log('class Comp => render');

    return (
      <div className="container">
        <h2>Class Style Component</h2>


        <p>Number : {this.state.initNumber}</p>
        <button onClick={() => {
          this.setState({ initNumber: Math.random() });
        }}>
          random
        </button>
        <p>Date : {this.state.date}</p>
        <button onClick={() => {
          this.setState({ date: new Date().toString() });
        }}>
          date
        </button>
      </div>
    )
  }
}
function FunctionComp(props) {
  const num = useState(props.initNumber);
  const setNum = num[1];

  // const dateState = useState(new Date().toString())
  // const date = dateState[0]
  // const setDate = dateState[1]
  // index 0과 1 한꺼번에 대입
  const [date, setDate] = useState(new Date().toString());

  return (
    <div className="container">
      <h2>Function Style Component</h2>
      <p>Number2 : {num[0]}</p>
      <button onClick={() => {
        setNum(Math.random());
      }}>random</button>
      <p>Date2 : {date}</p>
      <button onClick={() => { setDate(new Date().toString()) }}>
        date
      </button>
    </div>
  )
}

function App() {

  const [isShown, setShow] = useState(true);
  return (
    // return 되는 요소는 반드시 1개

    <div className="App">
      <h1>Hello World</h1>
      {
        isShown ? <ClassComp initNumber={2}></ClassComp> : null
      }
      <FunctionComp initNumber={2}></FunctionComp>
    </div>
  );
}

export default App;
