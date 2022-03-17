import './App.scss'

function App() {
  return (
    <div className="App">
      <h1 className='react'>React</h1>
      <div>
        My Div
      </div>

      <style jsx>
        {`
          div{
            color: red;
          }
        `}
      </style>
    </div>
  );
}

export default App;
