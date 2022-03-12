import React, { useRef, useState } from 'react'

export default function Counter() {
  const [number, setNumber] = useState(0)
  const value = useRef()

  function multiply(){
    setNumber(
      number * value.current.value
    )
  }

  function divide(){
    setNumber(
      number / value.current.value
    )
  }
  return (
    <>
      <div style={{
        margin: '20px'
      }}>
        <input ref={value} type={'number'}/>
        <button onClick={multiply}>Multiply</button>
        <button onClick={divide}>Divide</button>
      </div>
      <div></div>
      <button style={{margin: '20px'}} onClick={() => setNumber(number + 1)}>Increment</button>
      <button style={{marginRight: '20px'}} onClick={() => setNumber(number - 1)}>Decrement</button>
      <button onClick={() => setNumber(0)}>Set To Zero</button>
      <div style={{
        width: '250px',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'space-around',
        fontSize: '25px',
      }}>{number}</div>
    </>
    
  )
}
