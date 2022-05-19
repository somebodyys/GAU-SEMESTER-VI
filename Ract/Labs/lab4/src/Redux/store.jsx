import { configureStore } from "@reduxjs/toolkit";
import logger from "redux-logger";
import TodosReducer from "./reducers/TodosReducer";
import { applyMiddleware } from 'redux'

export default configureStore({
    reducer: {
        todos: TodosReducer
    }
}, applyMiddleware(logger))