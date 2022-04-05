import { DrinksProvider } from "./contexts/DrinksContext";
import { Drinks } from "./pages/Drinks";

function App() {
  return (
    <DrinksProvider>
      <Drinks/>
    </DrinksProvider>
  );
}

export default App;
