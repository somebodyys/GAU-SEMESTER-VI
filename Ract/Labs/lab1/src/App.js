import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Days from "./components/Days"
import Counter from "./components/Counter"

function App() {
  return (
    <Router>
      <nav>
        <Link to="/days">Days Of week</Link>
        <br/>
        <Link to="/counter">Counter</Link>
      </nav>
      <Routes>
        <Route path="/days" element={ <Days/> } />
        <Route path="/counter" element={ <Counter/> } /> 
      </Routes>
    </Router>
  );
}

export default App;
