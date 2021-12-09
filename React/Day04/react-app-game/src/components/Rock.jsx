import React, { Component } from 'react';
import rock from '../images/rock.png'
class Rock extends Component {
    render() {
        return (
            
              <img src={ rock } onClick={ this.props.onSubmit(1)}
              />  
            
        );
    }
}

export default Rock;