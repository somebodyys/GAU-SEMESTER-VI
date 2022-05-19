import { useState } from "react";
import { useDispatch } from "react-redux";
import { CREATE_JOKE } from "../Redux/ActionTypes";

const JokeInput = () => {

    const dispatch = useDispatch();
    const [jokeName, setJokeName] = useState("")

    const handleCreate = () => {
        dispatch({
            type: CREATE_JOKE,
            payload: {
                joke: jokeName
            }
        })
    }

    return (
        <div>
            <input 
                type="text" 
                placeholder="Joke..."
                value={jokeName}
                onChange={event => setJokeName(event.target.value)}
            />
            <button onClick={handleCreate}>Save joke</button>
        </div>
    )
}

export default JokeInput;