import React, { Component } from 'react';
import scissors from '../images/scissors.png'
class Scissors extends Component {
    render() {
        return (
            
              <img src={ scissors } onClick={ this.props.onSubmit(0)}
              />
            
        );
    }
}

export default Scissors;