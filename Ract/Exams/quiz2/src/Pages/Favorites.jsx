import { useSelector } from "react-redux";
import Favorite from "../Components/Favorite";

const Favorites = () => {
    const favorites = useSelector(state => state.favorites)

    return (
        <div>
            {
                favorites.map((joke, index) => (
                    <Favorite key={index} joke={joke} />
                ))
            }
        </div>
    )
}

export default Favorites;