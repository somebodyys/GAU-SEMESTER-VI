import { REMOVE_JOKE, UPDATE_JOKE, CREATE_JOKE, SET_JOKES } from "../ActionTypes"

export default function JokesReducer(state = [], action){
    switch (action.type) {
        case SET_JOKES:
            return action.payload
        case CREATE_JOKE:
            return [...state, action.payload]
        case UPDATE_JOKE:
            return state.map(joke => {
                return joke === action.payload.joke ? {
                    ...joke, joke: action.payload.newText
                } : joke
            })
        case REMOVE_JOKE:
            return state.filter(function(joke){
                return joke !== action.payload
            })
        default:
            return state;
    }
}