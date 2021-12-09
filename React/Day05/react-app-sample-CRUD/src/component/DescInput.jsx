import '../DescInput.css';
import { Component } from 'react';
class DescInput extends Component {
    render() {
        return (
            <form className='desc-input'>
                <input type='text' name='text' />
                <button type='submit'>추가</button>
            </form>
        );
    }
}
export default DescInput;