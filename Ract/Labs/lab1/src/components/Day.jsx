import React from 'react'

export default function Day({day}) {
  return (
    <div style={{
      padding: '15px',
      marginBottom: '30px'
    }}>
    
    კვირის დღე: 
    <input type={'text'} value={day.name}/>

    </div>
  )
}
