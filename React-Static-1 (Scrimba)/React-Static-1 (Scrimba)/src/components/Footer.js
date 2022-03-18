import React from "react"

export default function Header() {
    return(
        <footer className="bg-info text-light pt-2">
            <div className="text-center">
                <a href="https://twitter.com/p_abhishekk" target="_new"><i class="fa fa-twitter m-1" aria-hidden="true"></i></a>
                <i class="fa fa-facebook m-1" aria-hidden="true" ></i>
                <i class="fa fa-instagram m-1" aria-hidden="true"></i>
                <a href="https://github.com/maverikkano" target="_new"><i class="fa fa-github m-1" aria-hidden="true"></i></a>
                <p className="date"> March, 2022 </p>
            </div>
        </footer>
    );
}