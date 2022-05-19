import { SET_TODOS, ADD_TODO, REMOVE_TODO, TOGGLE_TODO, CLEAR } from "../ActionTypes"

export default function TodosReducer(state = [], action){
    switch (action.type) {
        case SET_TODOS:
            return action.payload;
        case ADD_TODO:
            return [...state, action.payload];
        case REMOVE_TODO:
            return state.filter(function(todo){
                return todo !== action.payload
            })
        case TOGGLE_TODO:
            return state.map(todo => {
                return todo === action.payload ? {
                    ...todo, completed: !todo.completed
                } : todo
            })
        case CLEAR:
            return [];
        default:
            return state;
    }
}