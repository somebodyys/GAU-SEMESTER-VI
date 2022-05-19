import { useDispatch } from "react-redux";
import { REMOVE_TODO, TOGGLE_TODO } from "../Redux/ActionTypes";

const Todo = ({todo}) => {
    const dispatch = useDispatch();

    const handleDelete = () => {
        dispatch({
            type: REMOVE_TODO,
            payload: todo
        })
    }

    const handleToggle = () => {
        dispatch({
            type: TOGGLE_TODO,
            payload: todo
        })
    }

    return (
        <div>
            <h4 style={{
                textDecoration: todo?.completed ? "line-through" : "none"
            }}>
                {todo?.title}
                <button onClick={handleToggle}>Toggle</button>
                <button onClick={handleDelete}>Delete</button>
            </h4>
        </div>
    )
}

export default Todo;