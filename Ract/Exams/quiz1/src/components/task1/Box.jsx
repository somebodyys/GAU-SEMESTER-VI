import React, { useState } from 'react'
import { Cube } from './Cube'

export const Box = () => {

    const [position, setPosition] = useState({
        "x": "0px",
        "y": "0px"
    })

    function handleMouseMove(e){
        let x = 0;
        let y = 0;

        if(e.clientY >= 175){
            y = 140;
        } else if(e.clientY <= 35){
            y = 0;
        }else{
            y = e.clientY - 35;
        }

        if(e.clientX <= 35 ){
            x = 0;
        } else if(e.clientX >= 440){
            x = 440;
        }
         else {
            x = e.clientX - 35;
        }

        setPosition({
            "x": x,
            "y": y
        })
    }
    
    return (
        <>
            <div style={{
                width: "500px",
                height: "200px",
                border: "solid 1px black",
                position: "relative"
                
            }} 
                onMouseMove={(e) => handleMouseMove(e)}
            >
                <Cube position={position}/>
            </div>
        </>
    )
}
