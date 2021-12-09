import './App.css';
import { Component } from 'react';
import DescInput from './DescInput';

class Section extends Component {
  render() {
    return (<section>
      <h4>사용되는 숫자는 0에서 9까지 서로 다른 숫자이다.</h4>
      <h4>숫자는 맞지만 위치가 틀렸을 때는 볼.</h4>
      <h4>숫자와 위치가 전부 맞으면 스트라이크.</h4>
      <h4>숫자와 위치가 전부 틀리면 아웃. "틀렸다"는 게 중요하다.</h4>
      <h4>물론 무엇이 볼이고 스트라이크인지는 알려주지 않는다.</h4>
    </section>
    );
  }
}
class Article extends Component {
  render() {
    return (<article>
      <table border="1">
        <tbody>
          <tr>
            <td>
              <div><strong>횟수</strong></div>
            </td>
            <td colSpan="3">
              <div><strong>숫자</strong></div>
            </td>
            <td>
              <div><strong>판정</strong></div>
            </td>
          </tr>
          <tr>
            <td>
              <div><strong>1</strong></div>
            </td>
            <td>
              <div>8</div>
            </td>
            <td>
              <div>3</div>
            </td>
            <td>
              <div>0</div>
            </td>
            <td>
              <div>아웃</div>
            </td>
          </tr>
          <tr>
            <td>
              <div><strong>2</strong></div>
            </td>
            <td>
              <div>6</div>
            </td>
            <td>
              <div>5</div>
            </td>
            <td>
              <div>9</div>
            </td>
            <td>
              <div>0S 1B</div>
            </td>
          </tr>
          <tr>
            <td>
              <div><strong>3</strong></div>
            </td>
            <td>
              <div>2</div>
            </td>
            <td>
              <div>6</div>
            </td>
            <td>
              <div>4</div>
            </td>
            <td>
              <div>1S 1B</div>
            </td>
          </tr>
          <tr>
            <td>
              <div><strong>4</strong></div>
            </td>
            <td>
              <div>1</div>
            </td>
            <td>
              <div>2</div>
            </td>
            <td>
              <div>6</div>
            </td>
            <td>
              <div>1S 2B</div>
            </td>
          </tr>
          <tr>
            <td>
              <div><strong>5</strong></div>
            </td>
            <td>
              <div>2</div>
            </td>
            <td>
              <div>1</div>
            </td>
            <td>
              <div>6</div>
            </td>
            <td>
              <div>3S 0B</div>
            </td>
          </tr>
        </tbody>
      </table>
    </article>
    );
  }
}


class Header extends Component {
  render() {
    return (
      <header>
        <h1>{this.props.intro}</h1>
      </header>
    );
  }
}

class Footer extends Component {
  render() {
    const list = [];
    for (let i = 0; i < this.props.desc.length; i++) {
      list.push(
        //                     arrow함수 사용 시 {} 여러줄
        //                     arrow함수 사용 시 () 한줄 return
        <h5 key={i} onClick={(e) => {
          console.dir(e);
          e.target.style.backgroundColor = 'beige';
          e.target.style.textDecoration = 'underline';
        }}>
          {this.props.desc[i]}
        </h5>
      );
    }

    return (<footer>{list}</footer>);
  }
}
class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      title: '야구게임 방식',
      rules: [
        '1. 830 - 들어맞는 숫자가 아예 없으므로 아웃. 이때부터 0, 3, 8이 후보에서 빠지므로 남는 숫자는 1, 2, 4, 5, 6, 7, 9다.',
        '2. 659 - 6이 있지만 위치가 다르므로 1볼. 게임 상으로는 어떤 숫자가 맞는지 모르기 때문에 가장 난감하다.',
        '3. 264 - 2가 있고 위치가 맞으며, 6이 있지만 위치가 다르므로 1스트라이크 1볼.',
        '4. 126 - 숫자는 전부 맞지만 위치는 6만 맞고 나머지 둘은 다르므로 1스트라이크 2볼.',
        '5. 216 - 전부 맞으므로 승리.'
      ]
    }
  }
  render() {
    return (
      // return 되는 요소는 항상 1개!
      <div>
        <h1>Hello</h1>
        <Header intro={this.state.title}></Header>
        <Section></Section>
        <Article></Article>
        <Footer desc={this.state.rules}></Footer>
        <DescInput send={function (userInput) {
          this.state.rules.push(userInput);
          this.setState({ rules: this.state.rules });
        }}></DescInput>
      </div>
    );
  }
}

export default App;

