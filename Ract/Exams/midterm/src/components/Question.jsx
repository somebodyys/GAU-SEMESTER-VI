import { useState } from "react";
import { useQuestions } from "../context/QuestionsContext";

const Question = () => {
    const { setStatus, questions, setScore} = useQuestions();
    const [index, setIndex] = useState(0)
    
    const answers = [...questions[index].incorrect_answers, questions[index].correct_answer]
    const shuffledAnswers = answers.sort((a, b) => 0.5 - Math.random())

    const handleChoice = (event) => {
        event.preventDefault();
        if(event.target.value === questions[index].correct_answer)
            setScore((score) => score + 1)
        
        if(index + 1 < questions.length){
            setIndex((index) => index + 1)
        }else{
            setStatus(false)
        }
    }
    return (
        <div>
            <br />
            <h3>{ questions[index].question }</h3>
            {
                shuffledAnswers.map((tempAnswer, index) => {
                    return (
                        <button key={index} onClick={handleChoice} value={tempAnswer}>{tempAnswer}</button>
                    )
                })
            }
        </div>
    )
}

export default Question;