import React, { useEffect, useState } from 'react'
export const Cube = ({position}) => {
    const [color, setColor] = useState(getRandomColor())
    
    function getRandomColor(){
        var randomColor = Math.floor(Math.random()*16777215).toString(16);
        
        return "#" + randomColor
    }

    useEffect(() => {
        const interval = setInterval(() => {
            setColor(getRandomColor())
        }, 1000);
    
      return () => {
        clearInterval(interval)
      }
    })
    
    return (
        <div style={{
            width: "60px", 
            height: "60px", 
            background: color,
            position : "absolute",
            left:position.x, 
            top:position.y
        }}></div>
    )
}
