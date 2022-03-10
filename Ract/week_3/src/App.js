import Film from "./components/Film";
import { useState, useEffect } from 'react'
import { FilmProvider } from './context/FilmContext'

function App() {

  const [increment, setIncrement] = useState(0)


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

  const handleIncrement = () => {
    setIncrement(increment + 1)
  }

  const handleDecrement = () => {
    setIncrement(increment - 1)
  }

  useEffect(() => {
    console.log("Loaded");
  }, [increment])
  
  return (
    <div className="App">
      <FilmProvider value={films}>
        <Film/>
      </FilmProvider>

      {increment}
      <button onClick={handleIncrement}>increment</button>
      <button onClick={handleDecrement}>increment</button>
      {
        films.map((item, index) => (
          <div key={index}>
            <Film 
            filmName={item.filmName} 
            releaseDate={item.releaseDate} 
            money={item.money}
            />
          </div>
        
        ))
      }
    </div>
  );
}

export default App;
