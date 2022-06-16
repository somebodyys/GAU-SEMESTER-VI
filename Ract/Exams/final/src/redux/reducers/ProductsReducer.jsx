import { SET_PRODUCTS } from "../ActionTypes"

export default function ProductReducer(state = [], action){
    switch (action.type) {
        case SET_PRODUCTS:
            return action.payload;
        default:
            return state;
    }
}