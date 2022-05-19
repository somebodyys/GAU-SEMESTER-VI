import { configureStore } from "@reduxjs/toolkit";
import JokesReducer from "./reducers/JokesReducer";
import { applyMiddleware } from 'redux';
import thunk from "redux-thunk";
import FavoriteJokesReducer from "./reducers/FavoriteJokesReducer";


export default configureStore({
    reducer: {
        jokes: JokesReducer,
        favorites: FavoriteJokesReducer
    }
}, applyMiddleware(thunk))