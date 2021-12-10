import React from 'react'
import '../css/TodoTemplate.css'

// children 부모 컴포너트에서 현재 컴퍼넌트에
function TodoTemplate({ children }) {
    return (
        <div className="TodoTemplate">
            <div className="app-title">일정 관리</div>
            <div className="content">{children}</div>
        </div>
    )
}

export default TodoTemplate
