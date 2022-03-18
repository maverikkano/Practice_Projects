import React from "react"

export default function Header() {
    return(
        <main className="main card-body bg-dark text-light">
            <h2 className="name card-text">Abhishek Patil</h2>
            <h6 className="designation card-text">Software Guy</h6>
            
            <div className="buttons px-3 text-center my-3">
                <a type="button" href="https://www.linkedin.com/in/abhishekbpatil16/" className="btn btn-primary col-sm-5 mr-1" target="_new"><i class="fa fa-solid fa-linkedin pr-1"></i> <span>LinkedIn</span></a>
                <a type="button" href="mailto:abhishekpatilofficial@gmail.com" className="btn btn-secondary col-sm-5 ml-1" target="_new"><i class="fa fa-envelope pr-1" aria-hidden="true"></i><span>Email</span></a>
            </div>

            <h3 className="info">About</h3>
            <p className="description">
                I'm a tech aficionado breaking my way into the internet cult. As a devoted developer (one might argue- despite being one), I am a fan of everything Zen.
            </p>
            
            <h3 className="info">Interests</h3>
            <p className="description">
                Guitarist. Singer. Gym freak. Finance geek. Wannabe traveller.
            </p>
        </main>
    );
}