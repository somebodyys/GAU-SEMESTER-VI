import axios from "axios";
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import Joke from "../Components/Joke";
import JokeInput from "../Components/JokeInput";
import { SET_JOKES } from "../Redux/ActionTypes";

const Jokes = () => {

    const URL = "https://icanhazdadjoke.com/search?limit=10"
    const dispatch = useDispatch();
    const jokes = useSelector(state => state.jokes)

    useEffect(() => {
        axios.get(URL, {
            headers:{
                Accept: 'application/json' 
            }
        }).then(response => {
            console.log(response.data.results)
            dispatch({
                type: SET_JOKES,
                payload: response.data.results
            })
        })
    }, [dispatch])

    return (
        <div style={{
            width: "50%",
            margin: "auto"
        }}>
            <h2>Jokes</h2>
            <JokeInput/>
            <br/>
            {
                jokes.map((joke, index) => (
                    <Joke key={index} joke={joke}/>
                ))
            }
        </div>
    )
}

export default Jokes;