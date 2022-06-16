import { Routes, Route, Navigate, Link } from "react-router-dom";
import ChartPage from "./pages/ChartPage";
import ProductsPage from "./pages/ProductsPage";
import SingleProductsPage from "./pages/SingleproductsPage";

function App() {
  return (
    <>
      <nav>
        <Link style={{
          marginRight: "20px"
        }} to="/products">Products</Link>
        <Link to="/checkout">Chart</Link>
      </nav>

      <Routes>
        <Route exact index path="/products" element={ <ProductsPage/> } />
        <Route exact path="/products/:id" element={ <SingleProductsPage/> } />
        <Route exact path="/checkout" element={ <ChartPage/> } />
        <Route exact path="*" element={ <Navigate to="/products" /> }/>
      </Routes>
    </>
    
  );
}

export default App;
