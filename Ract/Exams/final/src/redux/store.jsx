import { configureStore } from "@reduxjs/toolkit";
import ChartReducer from "./reducers/ChartReducer";
import ProductReducer from "./reducers/ProductsReducer";

export default configureStore({
    reducer: {
        chart: ChartReducer,
        products: ProductReducer
    }
})