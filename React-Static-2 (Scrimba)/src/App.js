import React from "react"
import Header from "./components/Header"
import Card from "./components/Card"
import data from "./data"

export default function App() {
    const cards = data.map(item => {
        return (
            <Card 
                key={item.id}
                {...item}
            />
        )
    })

    return(
        <div className="container col-sm-4 mx-auto">
            <Header />
            {cards}
        </div>
    );
}