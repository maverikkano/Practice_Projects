import React from "react"

export default function Header() {
    return(
        <main className="main">
            <h2 className="name">Abhishek Patil</h2>
            <h4 className="designation">Software Guy</h4>
            
            <button type="button"><i className="fa-brands fa-linkedin-in"></i> <span>Email</span></button>
            <button type="button"><i className="fa-solid fa-envelope"></i> <span>Email</span></button>
            
            <h3 className="info">About</h3>
            <p className="description">
                I'm a tech aficionado breaking my way into the internet cult. As a devoted developer (one might argue- despite being one), I am a fan of everything Zen. I think computers aren't meant to be codes, but communicated.
            </p>
            
            <h3 className="info">Interests</h3>
            <p className="description">
                Guitarist. Singer. Gym freak. Finance geek. Wannabe traveller.
            </p>
        </main>
    );
}