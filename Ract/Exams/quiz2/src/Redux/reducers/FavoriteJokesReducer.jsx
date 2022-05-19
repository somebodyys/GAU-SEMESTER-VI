import { ADD_TO_FAVORITES } from "../ActionTypes";

export default function FavoriteJokesReducer(state = [], action){
    switch (action.type) {
        case ADD_TO_FAVORITES:
            return [...state, action.payload]
        default:
            return state;
    }
}