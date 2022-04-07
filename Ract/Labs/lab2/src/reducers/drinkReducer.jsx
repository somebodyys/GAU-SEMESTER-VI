
export const TYPES = {
    SET_DRINKS: 'Set Drinks',
    DELETE_DRINKS: 'Delete Drinks'
}

const deleteDrinks = (drinks, list) => {
    let temp = drinks;
    list.deleteList.map(item => {
        temp = temp.filter((value) => {
            return value.idDrink !== item
        })
        return true
    })
    return temp;
}

const drinkReducer = (state, action) => {
    switch (action.type) {
        case TYPES.SET_DRINKS:
            return action.payload;
        case TYPES.DELETE_DRINKS:
            return deleteDrinks(state, action.payload)
        default:
            throw new Error();
    }
} 

export default drinkReducer;