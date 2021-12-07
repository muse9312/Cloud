import React, { Component } from 'react';
import logo from '../logo.svg';
import '../App.css';

class Header extends Component {
    constructor(props) {
        super(props);

        this.state = {

        }
    }
    render() {
        return (
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo" />
                <a
                    className="App-link"
                    href="https://reactjs.org"
                    target="_blank"
                    rel="noopener noreferrer"
                >

                    <h2> Web </h2>

                    <p> World Wide Web</p>


                </a>
            </header>
        )

    }
}

export default Header;