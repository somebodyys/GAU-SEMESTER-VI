
import axios from "axios";
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import ProductCard from "../components/ProductCard";
import { SET_PRODUCTS } from "../redux/ActionTypes";

const ProductsPage = () => {

    const URL = "https://fakestoreapi.com/products?limit=10"
    const dispatch = useDispatch();
    const products = useSelector(state => state.products )
    
    useEffect(() => {
      axios.get(URL).then(response => {
        dispatch({
            type: SET_PRODUCTS,
            payload: response.data
        })
      })
    }, [])
    

    return (
        <div style={{
            border: "solid 1px black",
            display: "flex",
            flexWrap: "wrap",
            padding: "10px"
        }}>
            {
                products.map((product, index) => (
                    <ProductCard key={index} product={product}/>
                ))
            }
        </div>
    )
}

export default ProductsPage;