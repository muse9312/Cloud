/** eslint-disable */
import logo from './logo.svg';
import './App.css';

import { BrowserRouter, Routes, Route, Link, Outlet, NavLink } from 'react-router-dom'

function App() {


  return (
    <div>



      <h1>React Router DOM Example</h1>
      <BrowserRouter>

        <ul>
          <li><Link to='/'>Home</Link></li>
          <li><Link to='/topics'>Topics</Link></li>
          <li><Link to='/contact'>Contact</Link></li>
        </ul>


        <Routes>
          <Route path="/" element={<Home />}></Route>
          <Route path="/Topics" element={<Topics />}>
            <Route path="1" element={<Topic />}></Route>
            <Route path="2" element={<Topic />}></Route>
            <Route path="3" element={<Topic />}></Route>

          </Route>
          <Route path="/Contact" element={<Contact />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

<ul>
  <li><a href='/'>Home</a></li>
  <li><a href='/topics'>Topics</a></li>
  <li><a href='/contact'>Contact</a></li>
</ul>

function Topic() {
  return (
    <div>


      Topic...

    </div>

  );
}

function Home() {
  return (
    <div>
      <h2>Home</h2>
      Home...
    </div>
  )
}
function Topics() {
  return (
    <div>
      <h2>Topics</h2>
      Topics...


      <ul>
        <li><NavLink to='/topics/1'>HTML</NavLink></li>
        <li><NavLink to='/topics/2'>JS</NavLink></li>
        <li><NavLink to='/topics/3'>React</NavLink></li>
      </ul>
      <Outlet></Outlet>
    </div>
  )
}

function Contact() {
  return (
    <div>
      <h2>Contact</h2>
      Contact...
    </div>
  )
}

export default App;
