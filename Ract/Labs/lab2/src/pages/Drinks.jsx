import React from 'react'
import Table from '../components/Table'
import { useDrinksSearch } from '../contexts/DrinksContext'

export const Drinks = () => {
    const setKeyword = useDrinksSearch()

    return (
        <div> 
            <div className="mb-4 mt-5 relative mx-auto flex justify-center">
                <input 
                    className="input border border-gray-400 appearance-none rounded w-2/3 px-3 py-3 pt-5 pb-2 focus focus:border-indigo-600 focus:outline-none active:outline-none active:border-indigo-600" 
                    type="text" 
                    autoFocus 
                    placeholder='Search...'
                    onChange={(event) => setKeyword(event.target.value)}
                />
            </div>

            <Table/>
        </div>
    )
}
