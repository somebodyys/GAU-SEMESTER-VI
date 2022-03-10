import { createContext } from "react";

export const FilmContext = createContext();


export const FilmProvider = ({children}) => {

    const films = [
        { 
          filmName: 'Mr.Nobody',
          releaseDate: 2020,
          money: 3000    
        },
        { 
          filmName: 'Test',
          releaseDate: 2021,
          money: 4000 
        },
        { 
          filmName: 'Hello World',
          releaseDate: 2022,
          money: 5000  
        }
    ];


    return (
        <FilmContext.Provider>
            {children}
        </FilmContext.Provider>
    )
}