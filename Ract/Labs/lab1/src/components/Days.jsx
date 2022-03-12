import React, { useState } from 'react'
import Day from "./Day";

export default function Days() {

  const [days] = useState([
    { id: 1, name: "ორშაბათი" },
    { id: 2, name: "სამშაბათი" },
    { id: 3, name: "ოთხშაბათი" },
    { id: 4, name: "ხუთშაბათი" },
    { id: 5, name: "პარასკევი" },
    { id: 6, name: "შაბათი" },
    { id: 7, name: "კვირა" },
  ])

  const [day, setDay] = useState(days[0])

  return (
    <div style={{ 
      padding: '20px', 
      border: 'solid 1px black', 
      backgroundColor: 'lightgray',
      width: '400px',
      height: '150px'
      }}>
      
      <Day day={day}/>

      {
        days.map(day => {
          return <button style={{
            width: '40px',
            marginRight: '15px',
            cursor: 'pointer'
          }} onClick={() => setDay(day)}>{day.id}</button>
        })
      }
    </div>
  )
}
