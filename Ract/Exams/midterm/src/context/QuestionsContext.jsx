import axios from "axios";
import { createContext, useContext, useEffect, useState } from "react"

const QuestionContext = createContext();

export function useQuestions(){
    return useContext(QuestionContext);
}

export function QuestionsProvider({ children }){

    const [status, setStatus] = useState(true);
    const [started, setStarted] = useState(false);
    const [questions, setQuestions] = useState([]);
    const [score, setScore] = useState(0);
    const [categories, setCategories] = useState([
        { id: 20, name: "Mythology" },
        { id: 21, name: "Sports" },
        { id: 22, name: "Geography" },
        { id: 23, name: "History" }
    ])
    const [parameters, setParameters] = useState({
        amount: 1,
        category: 20
    })

    useEffect(() => {
        axios.get(`https://opentdb.com/api.php`, {
            params: {
                amount: parameters.amount,
                category: parameters.category
            }
        }).then(response => {
            setQuestions(response.data.results)
            console.log(response.data.results)
        })
    }, [parameters])

    return (
        <QuestionContext.Provider value={{started, setStarted, status, setStatus, score, setScore, questions, categories, parameters, setParameters, setQuestions}}>
            { children }
        </QuestionContext.Provider>
    )
}