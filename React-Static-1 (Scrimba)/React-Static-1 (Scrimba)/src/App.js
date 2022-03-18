import React from "react"
import Header from "./components/Header.js"
import Main from "./components/Main.js"
import Footer from "./components/Footer.js"

export default function App() {
    return(
        <div className="container card col-sm-3 my-3 rounded-lg p-0">
            <Header />
            <Main />
            <Footer />
        </div>
    );
}