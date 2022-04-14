import Question from "../components/Question";
import { useQuestions } from "../context/QuestionsContext";
import Result from "./Result";


const Trivia = () => {
    const {started, setStarted, status, categories, parameters, setParameters} = useQuestions();

    const handleSubmit = (event) => {
        event.preventDefault();
        setStarted(true)
    }

    const handleAmountChange = (event) => {
        setParameters({...parameters, amount: event.target.value})
    }

    const handleCategoryChange = (event) => {
        setParameters({...parameters, category: event.target.value})
    }


    if(status){
        return (
            <div>
                <form onSubmit={handleSubmit}>
                    <input type="number" placeholder="Number Of Questions" onChange={handleAmountChange}/>
                    <br /> <br />
                    <select onChange={handleCategoryChange}>
                        {
                            categories.map((category) => {
                                return (
                                    <option key={category.id} value={category.id}>{category.name}</option>
                                )
                            })
                        }
                    </select>
                    <br/> <br />
                    <button type="submit">Start</button>
                </form>
                {
                    started ? <Question/> : ""
                }
            </div>
        );
    }

    return (
        <Result/>
    )
    
}

export default Trivia;