import { BrowserRouter as Router, Link, Route, Routes } from "react-router-dom";
import Favorites from "./Pages/Favorites";
import Jokes from "./Pages/Jokes";

function App() {
  return (
    <Router>
      <nav>
        <Link to="/jokes">All Jokes</Link>
        <br/>
        <Link to="/favorites">Favorite Jokes</Link>
      </nav>

      <Routes>
        <Route index path="/jokes" element={ <Jokes/> } />
        <Route path="/favorites" element={ <Favorites/>} />
      </Routes>
    </Router>
  );
}

export default App;
