import React, { Component } from 'react';

class Header extends Component {
    constructor(props) {
        super(props);
        this.state = {
            titie: "야구게임방식"
        }
    }

    render() {
        return (
            <header>

                <h1> {this.state.titie} </h1>

            </header>
        );
    }
}

export default Header;