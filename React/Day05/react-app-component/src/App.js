/* eslint-disable */

import logo from './logo.svg';
import './App.css';


function App() {

  // 클래스
  class ClassComp extends Component {
    constructor(props) {
      super(props);
      this.state = {
        initNumber: this.props.initNumber
      }
    }
    render() {
      return (
        <div className="container">
          <h2>Class Style Component</h2>
          <p>Number : {this.props.initNumber}</p>
        </div>
      )
    }
  }

  // 함수
  function FunctionComp(props) {
    const num = useState(props.initNumber)


    return (
      <div className="container">
        <h2>Function Style Component</h2>
        <p>Number : {num[0]} </p>
      </div>
    )
  }

  return (
    <div className="container">
      <h1>Hello World</h1>
      <ClassComp initNumber={1}></ClassComp>
      <FunctionComp initNumber={2}></FunctionComp>
    </div>
  );
}

export default App;
