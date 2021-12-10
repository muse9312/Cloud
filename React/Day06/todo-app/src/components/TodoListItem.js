import React from 'react';
import {
    MdCheckBoxOutlineBlank,
    MdRemoveCircleOutline,
    MdCheckBox
} from 'react-icons/md';
import '../css/TodoListItem.css';
const TodoListItem = (props) => {
    const { text, checked } = props.todo;
    return (
        <div className="TodoListItem">
            <div className={checked ? 'checkbox checked' : 'checkbox'}>
                {checked ? <MdCheckBox /> : <MdCheckBoxOutlineBlank />}
                <div className="text">{text}</div>
            </div>
            <div className="remove">
                <MdRemoveCircleOutline></MdRemoveCircleOutline>
            </div>
        </div>
    );
};
export default TodoListItem;