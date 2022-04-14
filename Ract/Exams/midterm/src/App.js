import { QuestionsProvider } from "./context/QuestionsContext";
import Trivia from "./pages/Trivia";

function App() {
  return (
    <QuestionsProvider>
      <Trivia/>
    </QuestionsProvider>
  );
}

export default App;
