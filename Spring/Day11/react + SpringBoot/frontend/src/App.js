/* eslint-disable */
import logo from './logo.svg';
import './App.css';
import {
  BrowserRouter, Routes, Route, Link
} from 'react-router-dom';
import { useState, useEffect } from 'react';

import axios from 'axios';


const Header = function () {
  return (
    <div className="p-5 bg-primary text-white text-center">
      <h1 if="${session.user_info == null}">
        <a href="/signin" class="link-dark">
          로그인해주세요!
        </a>
      </h1>

    </div>

  )
}

const Nav = function () {
  return (
    <nav className="navbar navbar-expand-sm bg-dark navbar-dark">
      <div className="container-fluid">
        <ul className="navbar-nav">
          <li className="nav-item">
            <a className="nav-link active" href="#">Active</a>
          </li>
          <li className="nav-item">
            <a className="nav-link" href="#">Link</a>
          </li>
          <li className="nav-item">
            <a className="nav-link" href="#">Link</a>
          </li>
          <li className="nav-item">
            <a className="nav-link disabled" href="#">Disabled</a>
          </li>
        </ul>
      </div>
    </nav>

  )

}

const Content = function () {
  return (
    <div className="container mt-5">
      <div className="row">
        <div className="col-sm-4">
          <h2>About Me</h2>
          <h5>Photo of me:</h5>
          <div className="fakeimg">Fake Image</div>
          <p>Some text about me in culpa qui officia deserunt mollit anim..</p>
          <h3 className="mt-4">Some Links</h3>
          <p>Lorem ipsum dolor sit ame.</p>


        </div>

      </div>
    </div>

  )

}
const Footer = function () {
  return (
    <div className="mt-5 p-4 bg-dark text-white text-center">
      <p>Footer</p>
    </div>

  )

}

const BoardList = function () {

  const [list, setlist] = useState([]);

  useEffect(function () {

    axios({
      url: 'http://localhost:8080/api/board/list',
      method: 'get'
    }).then(function (res) {
      setlist(res.data)
    })



  }, [])






  return (
    <div class="container mt-5">
      <div class="row">
        <table class="table table-hover">
          <thead>
            <tr>
              <th>번호</th><th>제목</th><th>작성자</th>
            </tr>
          </thead>
          <tbody>
            {list.map(function (value) {
              return (
                <tr>


                  <td>{value.id}</td>
                  <td>{value.title}</td>
                  <td>{value.user_id}</td>
                </tr>
              )

            })}
          </tbody>
        </table>
        <button type="button" class="btn btn-primary btn-block" id="write-btn">글쓰기</button>
      </div>
    </div>
  )

}

const SignUp = function () {
  return (


    <div className="container mt-5">
      <div className="row">
        <form onSubmit={function (e) {
          e.preventDefault();
          const formData = new FormData();
          const email = e.target['0'].value;
          const pwd = e.target['1'].value;
          const name = e.target['2'].value;

          formData.append("email", email);
          formData.append("pwd", pwd);
          formData.append("name", name);

          axios({
            url: 'http://localhost:8080/api/signup',
            method: 'post',
            data: formData
          }).then(function (res) {
            console.log(res.data);
            window.location = '/';
          })

        }} >
          <div className="mb-3">
            <label for="email">Email:</label>
            <input type="text" className="form-control" id="email" name="email"></input>
          </div>
          <div className="mb-3">
            <label for="pwd">Password:</label>
            <input type="password" className="form-control" id="pwd" name="pwd"></input>
          </div>
          <div className="mb-3">
            <label for="name">Name:</label>
            <input type="text" className="form-control" id="name" name="name"></input>
          </div>
          <div className="d-grid gap-2">
            <button className="btn btn-primary" id="signup">회원가입</button>
            <a href="/signup" class="link-dark"></a>
          </div>



        </form>

      </div>
    </div >


  )

}

const SignIn = function () {
  return (
    <div class="container mt-5">
      <div class="row">
        <form onSubmit={function (e) {
          e.preventDefault();
          const formData = new FormData();
          const email = e.target['0'].value;
          const pwd = e.target['1'].value;

          formData.append("email", email);
          formData.append("pwd", pwd);

          axios({
            url: 'http://localhost:8080/api/signin',
            method: 'post',
            data: formData
          }).then(function (res) {
            console.log(res.data);
            if (res.data.code === 200) {
              alert('로그인성공');
              // sessionStorage.setItem("token", 1234);
              window.location = '/';

            } else {
              alert('이메일과 비밀번호를 확인해주세요');
            }
          })

        }} >
          <div class="mb-3 input-group flex-nowrap">
            <span class="input-group-text">💻</span>
            <input type="text" class="form-control" name="email" placeholder="email"></input>
          </div>
          <div class="mb-3 input-group flex-nowrap">
            <span class="input-group-text">🔒</span>
            <input type="password" class="form-control" name="pwd" placeholder="password"></input>
          </div>
          <div class="d-grid gap-2">
            <button class="btn btn-primary" id="signin">로그인</button>
          </div>
          <br />

        </form>
        <Link to="/signup">
          <div class="d-grid gap-2">
            <button class="btn btn-primary" id="signin">회원가입</button>
          </div>
        </Link>
      </div>
    </div>

  )

}

function App() {

  return (
    <div className="App">
      <Header />
      <Nav />


      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Content />}></Route>
          <Route path="/signup" element={<SignUp />}></Route>
          <Route path="/signin" element={<SignIn />}></Route>
          <Route path="/board/list" element={<BoardList />}></Route>
        </Routes>
      </BrowserRouter>

      <Footer />


    </div>
  );
}

export default App;
