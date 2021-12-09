import React, { Component } from 'react';
import paper from '../images/paper.png'
class Paper extends Component {
    render() {
        return (
            
              <img src={ paper } onClick={ this.props.onSubmit(2)}
              />  
            
        );
    }
}

export default Paper;