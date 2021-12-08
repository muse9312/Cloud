import React, { Component } from 'react';

class Footer extends Component {

  render() {

    let list = [];
   
    for (let i = 0; i < this.props.desc.length; i++) {
      list.push(
      <h5 key={i} onClick={(e) => {

        e.target.style.backgroundColor = 'beige';
e.target.style.textDecoration = 'underline';
      }}
      >
        
        {this.props.desc[i]}
      
      
      </h5> 
      
      )
      
    }

   
    return (
      <h2>

        {list}
      </h2>
    );

  }
}

export default Footer;