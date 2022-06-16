import { useDispatch } from "react-redux";
import { Link } from "react-router-dom";
import { ADD_ITEM } from "../redux/ActionTypes";

const ProductCard = ({product}) => {
    const dispatch = useDispatch();
    return (
        <div style={{
            width: "250px",
            border: "solid 1px black",
            margin: "15px",
            padding: "10px",
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
            justifyContent: "space-between"        
        }}>
            <div>
                <img style={{
                    width: "70px",
                    height: "100px"
                }} src={product.image} alt="" />
            </div>
            <div>
                <h3>{product?.title}</h3>
            </div>
            <div>
                <h2 style={{
                    color:"green"
                }}>{product.price}$</h2>
            </div>
            <div>
                <Link to={`/products/${product.id}`}>Details</Link>
                    
                <button 
                    style={{
                    marginLeft: "10px"  
                    }}
                    onClick={() => dispatch({
                        type: ADD_ITEM,
                        payload: product
                    })}
                >
                    Add to Chart
                </button>
            </div>
            
        </div>
    )
}

export default ProductCard;