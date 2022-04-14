import { useQuestions } from "../context/QuestionsContext";

const Result = () => {
    const { setStarted, setStatus, score, setScore} = useQuestions();

    const handleReset = () => {
        setStatus(true)
        setScore(0)
        setStarted(false)
    }

    return (
        <>
            <div>
                Correct Answers : {score}
            </div>
            <br />
            <button onClick={handleReset}>Start Over</button>
        </>
    )
}

export default Result;