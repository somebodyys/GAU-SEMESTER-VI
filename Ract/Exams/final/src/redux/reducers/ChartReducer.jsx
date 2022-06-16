import { CLEAR_CHART, ADD_ITEM, REMOVE_PRODUCT } from "../ActionTypes"

export default function ChartReducer(state = [], action){
    switch (action.type) {
        case ADD_ITEM:
            return [...state, action.payload];
        case REMOVE_PRODUCT:
            return state.filter(function(value, index){
                return index != action.payload
            })
        case CLEAR_CHART:
            return [];
        default:
            return state;
    }
}