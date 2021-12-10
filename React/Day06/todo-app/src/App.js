/** eslint-disable */

import logo from './logo.svg';
import './App.css';

import { useState, useRef, useCallback } from 'react'

import TodoTemplate from './components/TodoTemplate';
import TodoInsert from './components/TodoInsert';
import TodoList from './components/TodoLIst';

function App() {
  const [todos, setTodos] = useState([
    { id: 1, text: '리액트의 기초 알아보기', checked: true },
    { id: 2, text: '컴포넌트 스타일링해 보기', checked: true },
    { id: 3, text: '일정 관리 앱 만들어 보기', checked: false }


  ]);

  const nextId = useRef(todos.length + 1);
  const onInsert = useCallback(
    (text) => {
      const todo = {
        id: nextId.current, text,
        checked: false,
      };
      setTodos(todos.concat(todo));
      nextId.current += 1;
    },
    [todos]
  );


  // 일정 삭제 기능 구현
  const onRemove = useCallback(
    (id) => {
      setTodos(todos.filter((todo) => todo.id !== id));
    },
    [todos]
  );

  // 일정 수정 기능 구현

  const onModified = useCallback(
    (id) => {
      setTodos(todos.filter((todo) => todo.id !== id));
    },
    [todos]
  )



  // TodoList에 props로 전달
  const onToggle = useCallback(
    (id) => {
      setTodos(
        todos.map((todo) =>
          todo.id === id ? { ...todo, checked: !todo.checked } : todo
        ),
      );
    },
    [todos]
  );


  return (
    <TodoTemplate>
      <TodoInsert onInsert={onInsert}></TodoInsert>
      <TodoList todos={todos} onRemove={onRemove} onToggle={onToggle} ></TodoList>


    </TodoTemplate>

  );
}

export default App;
