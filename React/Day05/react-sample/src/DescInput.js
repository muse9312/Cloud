import './DescInput.css';
import { Component } from 'react';
class DescInput extends Component {
    render() {
        return (
            <form className='desc-input'>
                <input type='text' />
                <button type='submit' onClick={(e) => {
                    const text = document.querySelector('text').value;
                    this.props.send(text);
                    e.preventDefault();
                }}>추가</button>
            </form>
        );
    }
}
export default DescInput;