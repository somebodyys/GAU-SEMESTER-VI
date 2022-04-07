import { useForm } from "react-hook-form"
import { useDrinks, useDrinksDelete } from "../contexts/DrinksContext"

const Table = () => {

    const drinks = useDrinks()
    const drinksDelete = useDrinksDelete()

    const { register, handleSubmit} = useForm()

    const onSubmit = data => {
        drinksDelete(data)
    }

    return(
        <div className="flex flex-col">
            <button type="button" onClick={handleSubmit(onSubmit)}>Delete</button> 
            <div className="overflow-x-auto sm:-mx-6 lg:-mx-8">
                <div className="py-2 inline-block min-w-full sm:px-6 lg:px-8">
                    <div className="overflow-hidden">
                        <table className="min-w-full">
                            <thead className="border-b">
                                <tr>
                                    <th scope="col" className="text-sm font-medium text-gray-900 px-6 py-4 text-left" >
                                           
                                    </th>
                                    <th scope="col" className="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                                        ID
                                    </th>
                                    <th scope="col" className="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                                        Image
                                    </th>
                                    <th scope="col" className="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                                        Drink
                                    </th>
                                    <th scope="col" className="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                                        Category
                                    </th>
                                    <th scope="col" className="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                                        Instructions
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                {                                
                                    drinks.map(drink => {
                                        
                                        return (
                                            <tr key={drink.idDrink} className="border-b">
                                                <td className="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">
                                                    <input type="checkbox" value={drink.idDrink} {...register("deleteList[]")}/>
                                                </td>
                                                <td className="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">
                                                    {drink.idDrink}
                                                </td>
                                                <td className="text-lg text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                                    <img src={drink.strDrinkThumb} alt="" srcSet="" />
                                                </td>
                                                <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                                    {drink.strDrink}
                                                </td>
                                                <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                                    {drink.strCategory}
                                                </td>
                                                <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                                    {drink.strInstructions}
                                                </td>
                                            </tr>
                                        )
                                    })
                                }
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Table;