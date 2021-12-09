/* eslint-disable */

import logo from './logo.svg';
import './App.css';
import Header from './component/Header';
import Section from './component/Section';
import Article from './component/Article';
import Footer from './component/Footer';
import DescInput from './component/DescInput';

function App() {
  return (

    <div className="App">

      <Header />
      <Section />
      <Article />
      <Footer />

      <DescInput></DescInput>

    </div>
  );
}

export default App;
