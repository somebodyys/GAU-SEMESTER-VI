import { useDispatch, useSelector } from "react-redux";
import ProductCard from "../components/ProductCard";
import { ADD_ITEM, REMOVE_PRODUCT } from "../redux/ActionTypes";

const ChartPage = () => {
    const chart = useSelector(state => state.chart )
    const dispatch = useDispatch();

    return (
        <div>
            <div>
                <h1 style={{
                    color: "green"
                }}>
                    total: {chart.reduce(function(prev, current) {
                            return prev + +current.price
                            }, 0)}$ 
                </h1>
            </div>
            <div style={{
                border: "solid 1px black",
                padding: "15px",
                display: "flex",
                flexWrap: "wrap"
            }}>
                {
                    chart.map((product, index) => (
                        <div key={index}>
                            <ProductCard product={product}/>
                            <div>
                                <button onClick={() => dispatch({
                                    type: REMOVE_PRODUCT,
                                    payload: index
                                })}>-</button>
                                <button onClick={() => dispatch({
                                    type: ADD_ITEM,
                                    payload: product
                                })}>+</button>
                            </div>
                        </div>                     
                    ))
                } 
            </div>
        </div>
    )
}

export default ChartPage;