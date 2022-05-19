import axios from "axios";
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import AddTodo from "../Components/AddTodo";
import Todo from "../Components/Todo";
import { CLEAR, SET_TODOS } from "../Redux/ActionTypes";

const Todos = () => {

    const URL = "https://jsonplaceholder.typicode.com/todos"
    const dispatch = useDispatch();
    const todos = useSelector(state => state.todos)

    useEffect(() => {
        axios.get(URL).then(response => {
            console.log(response)
            dispatch({
                type: SET_TODOS,
                payload: response.data
            })
        })
    }, [dispatch])

    const handleClear = () => {
        dispatch({
            type: CLEAR
        })
    }
    

    return (
        <div>
            <AddTodo/>
            <br/>
            <button onClick={handleClear}>Clear</button>
            {
                todos.map((todo, index) => (
                    <Todo key={index} todo={todo}/>
                ))
            }
            <Todo/>
        </div>
    )
}

export default Todos;