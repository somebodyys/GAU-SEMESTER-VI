import axios from "axios";
import { createContext, useContext, useEffect, useState } from "react";

const DrinksContext = createContext()
const DrinksSearchContext = createContext()
const DrinksDelete = createContext()

export function useDrinks(){
    return useContext(DrinksContext)
}

export function useDrinksSearch(){
    return useContext(DrinksSearchContext)
}

export function useDrinksDelete(){
    return useContext(DrinksDelete)
}



export function DrinksProvider({ children }){

    const [drinks, setDrinks] = useState([]);
    const [keyword, setKeyword] = useState("");

    useEffect(() => {
        axios.get("https://www.thecocktaildb.com/api/json/v1/1/search.php", {
            params: {
                s: keyword 
            }
        }).then(response => {
            setDrinks(response.data.drinks ?? [])
        })
    }, [keyword])
    
    const deleteDrinks = (list) => {
        let temp = drinks;
        list.deleteList.map(item => {
            temp = temp.filter((value) => {
                return value.idDrink != item
            })
        })
        setDrinks(temp)
    }

    return (
        <DrinksContext.Provider value={drinks}>
            <DrinksSearchContext.Provider value={setKeyword}>
                <DrinksDelete.Provider value={deleteDrinks}>
                    { children }
                </DrinksDelete.Provider>
            </DrinksSearchContext.Provider>
        </DrinksContext.Provider>
    );
}