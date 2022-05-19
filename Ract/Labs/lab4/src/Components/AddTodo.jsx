import { useState } from "react";
import { useDispatch } from "react-redux";
import { ADD_TODO } from "../Redux/ActionTypes";

const AddTodo = () => {
    const dispatch = useDispatch();
    const [todoName, setTodoName] = useState("");
    const handleAdd = () => {
        dispatch({
            type: ADD_TODO,
            payload: {
                userId: 1,
                title: todoName,
                completed: false
            }
        })
    }

    return(
        <div>
            <input 
                type="text" 
                placeholder="New Todo..."
                value={todoName}
                onChange={event => setTodoName(event.target.value)}
            />
            <button onClick={handleAdd}>add</button>
        </div>
        
    )
}

export default AddTodo;