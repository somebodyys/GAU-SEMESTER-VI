import { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { useParams } from "react-router-dom";

const SingleProductsPage = () => {

    const params = useParams();
    const products = useSelector(state => state.products )
    const [product, setProduct] = useState({});

    useEffect(() => {
        setProduct(
            products.find(item => item.id == params.id)
        )
    }, [params])
    
    return (
        <div style={{
            border: "solid 1px black",
            padding: "20px",
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
            justifyContent: "space-around"
        }}>
            <div>
                <img style={{
                    width: "250px"
                }} src={product.image} alt="" />
            </div>
            <h1>{product?.title}</h1>

            <div style={{
                color: "green"
            }}>
                <h2>{product.price}$</h2>
            </div>
            <div>
                <h3>{product.category}</h3>
                <p>
                    {product.description}
                </p>
            </div>
        </div>
    )
}

export default SingleProductsPage;