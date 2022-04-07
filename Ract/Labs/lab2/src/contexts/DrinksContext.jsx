import axios from "axios";
import { createContext, useContext, useEffect, useReducer, useState } from "react";
import drinkReducer, { TYPES } from "../reducers/drinkReducer";

const DrinksContext = createContext()
const DrinksSearchContext = createContext()

export function useDrinks(){
    return useContext(DrinksContext)
}

export function useDrinksSearch(){
    return useContext(DrinksSearchContext)
}

export function DrinksProvider({ children }){

    const [drinks, dispatch] = useReducer(drinkReducer, []);
    const [keyword, setKeyword] = useState("");

    useEffect(() => {
        axios.get("https://www.thecocktaildb.com/api/json/v1/1/search.php", {
            params: {
                s: keyword 
            }
        }).then(response => {
            dispatch({ type: TYPES.SET_DRINKS, payload: response.data.drinks ?? []})
        })
    }, [keyword])
    
    return (
        <DrinksContext.Provider value={{drinks, dispatch}}>
            <DrinksSearchContext.Provider value={setKeyword}>
                { children }
            </DrinksSearchContext.Provider>
        </DrinksContext.Provider>
    );
}