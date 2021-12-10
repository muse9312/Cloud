import React from 'react';
import {
    MdCheckBoxOutlineBlank,
    MdRemoveCircleOutline,
    MdCheckBox
} from 'react-icons/md';
import '../css/TodoListItem.css';
const TodoListItem = (props) => {
    const { id, text, checked } = props.todo;
    return (
        <div className="TodoListItem">
            <div className={checked ? 'checkbox checked' : 'checkbox'}
                onClick={function () {
                    props.onToggle(id)
                }}
            >
                {checked ? <MdCheckBox /> : <MdCheckBoxOutlineBlank />}
                <div className="text">{text}</div>
            </div>

            {/* 항목 제거 */}
            <div className="remove" onClick={function () {
                props.onRemove(id)
            }}>
                <MdRemoveCircleOutline></MdRemoveCircleOutline>
            </div>

            {/* 항목 수정 */}
            <div className="modify" onClick={function () {
                props.onRemove(id)
            }}>
                <MdRemoveCircleOutline></MdRemoveCircleOutline>
            </div>



        </div>
    );
};
export default TodoListItem;