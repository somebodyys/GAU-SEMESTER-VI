import React, { useState } from 'react'

export const RandomNames = () => {    
    
    const data = [{"id":7235,"uid":"16df6390-0570-441c-aefb-855792dc1daf","brand":"Amstel","name":"Samuel Smith’s Oatmeal Stout","style":"German Wheat And Rye Beer","hop":"Magnum","yeast":"1272 - American Ale II","malts":"Black malt","ibu":"13 IBU","alcohol":"9.4%","blg":"16.7°Blg"},{"id":7182,"uid":"f7ff82ca-8179-4655-8220-edc8e14a2d24","brand":"Red Stripe","name":"90 Minute IPA","style":"Vegetable Beer","hop":"Vanguard","yeast":"1099 - Whitbread Ale","malts":"Caramel","ibu":"39 IBU","alcohol":"9.3%","blg":"19.3°Blg"},{"id":9197,"uid":"7b2a90e7-d2d7-4d8a-8624-bd2943e03889","brand":"Kirin","name":"St. Bernardus Abt 12","style":"Stout","hop":"Cluster","yeast":"1187 - Ringwood Ale","malts":"Vienna","ibu":"21 IBU","alcohol":"4.8%","blg":"5.1°Blg"},{"id":3865,"uid":"cccd7fbb-d3f2-4c59-a36c-66b1f5dcfca7","brand":"Harp","name":"Westmalle Trappist Tripel","style":"Fruit Beer","hop":"Glacier","yeast":"3638 - Bavarian Wheat","malts":"Chocolate","ibu":"53 IBU","alcohol":"3.9%","blg":"10.9°Blg"},{"id":8867,"uid":"0a274448-6288-470f-aa4b-4d4ec1b747a2","brand":"Murphys","name":"Kirin Inchiban","style":"Fruit Beer","hop":"Simcoe","yeast":"5733 - Pediococcus","malts":"Munich","ibu":"91 IBU","alcohol":"2.6%","blg":"7.2°Blg"}]

    const [nameObject, setNameObject] = useState(generateRandomObject())

    function generateRandomObject(){
        const newRandObject = data[Math.floor(Math.random() * data.length)]

        return {
            'name': newRandObject.brand,
            'but1': newRandObject.brand,
            'but2': newRandObject.hop,
            'but3': newRandObject.ibu,
            'but4': newRandObject.malts,
            'but5': newRandObject.blg
        };
    }

    function handleRandomData(e){
        setNameObject(generateRandomObject());
    }

    return (
        <>
            <div>{nameObject.name}</div>
            <button onClick={() => setNameObject({...nameObject, 'name': nameObject.but1})}>{nameObject.but1}</button>
            <button onClick={() => setNameObject({...nameObject, 'name': nameObject.but2})}>{nameObject.but2}</button>
            <button onClick={() => setNameObject({...nameObject, 'name': nameObject.but3})}>{nameObject.but3}</button>
            <button onClick={() => setNameObject({...nameObject, 'name': nameObject.but4})}>{nameObject.but4}</button>
            <button onClick={() => setNameObject({...nameObject, 'name': nameObject.but5})}>{nameObject.but5}</button>
            <br />
            <button onClick={(e) => handleRandomData(e)}>Random Button</button>
        </>
        
    )
}
