import React, { Component } from 'react';

class Footer extends Component {
    constructor(props) {
        super(props);
        this.state = {

            desc: {
                html: 'HTML is HyperText Markup Language',
                css: 'CSS is HyperText Markup Language',
                javascript: 'JavaScript is HyperText Markup Language',


            }



        }
    }
    render() {
        return (
            <footer className="App-footer">

                <p1>{this.state.desc.html}</p1>
                <br />
                <p1>{this.state.desc.css}</p1>
                <br />
                <p1>{this.state.desc.javascript}</p1>



            </footer>

        );
    }
}

export default Footer;