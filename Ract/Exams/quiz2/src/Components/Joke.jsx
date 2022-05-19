import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { ADD_TO_FAVORITES, REMOVE_JOKE, UPDATE_JOKE } from "../Redux/ActionTypes";

const Joke = ({joke}) => {

    const [editMode, setEditMode] = useState(false)
    const [editJoke, setEditJoke] = useState();
    const dispatch = useDispatch();
    const favorites = useSelector(state => state.favorites)

    const handleFavorite = () => {
        if(!favorites.some(item => item.joke === joke.joke)){
            dispatch({
                type: ADD_TO_FAVORITES,
                payload: joke
            })
        }
    }

    const handleDelete = () => {
        dispatch({
            type: REMOVE_JOKE,
            payload: joke
        })
    }

    const handleSave = () => {
        dispatch({
            type: UPDATE_JOKE,
            payload: {
                joke: joke,
                newText: editJoke
            }
        })

        setEditMode(false)
    }

    useEffect(() => {
        setEditJoke(joke.joke)
    }, [joke.joke])

    return (
        editMode 
        ? 
            <div style={{
                marginTop: "15px",
                marginBottom: "15px"
            }}>
                <input 
                    type="text" 
                    value={editJoke} 
                    onChange={event => setEditJoke(event.target.value)}
                />
                <button onClick={() => { setEditJoke(joke.joke); setEditMode(false)}}>cancel</button>
                <button onClick={handleSave}>Save</button>
            </div>
        : 
            <div>
                <h3>
                    {joke.joke}
                </h3>
                <button onClick={handleFavorite}>Add To Favorites</button>
                <button onClick={() => setEditMode(true)}>Update</button>
                <button onClick={handleDelete}>Delete</button>
            </div>
    )
}

export default Joke;