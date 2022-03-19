import React from "react"

export default function Card(props) {
    return(
        <div className="card p-2 m-3">
            <div className="row">
                <div className="image col-sm-4">
                    <img src={props.imageUrl} className="rounded" width="125" height="168"/>
                </div>
                <div className="description col-sm-8">
                    <div className="row location">
                        <span className="country col-sm-4"><i class="fa-solid fa-location-dot"></i>{props.location}</span>
                        <a className="map-location col-sm-8" href={props.googleMapsUrl} target="_black">View in Google Maps</a>
                    </div>
                    <h2 className="row title">{props.title}</h2>
                    <div className="row date">{props.startDate}</div>
                    <div className="row summary">{props.description}</div>
                </div>
            </div>
        </div>
    );

    // return(
    //     <div className="card p-2 m-3">
    //         <div className="row">
    //             <div className="image col-sm-4">
    //                 <img src="https://static.toiimg.com/photo/86194664/86194664.jpg?v=3" className="rounded" width="125" height="168"/>
    //             </div>
    //             <div className="description col-sm-8">
    //                 <div className="row location">
    //                     <span className="country col-sm-4"><i class="fa-solid fa-location-dot"></i>India</span>
    //                     <a className="map-location col-sm-8" href="https://maps.google.com/maps/ms?ie=UTF8&t=m&oe=UTF8&msa=0&msid=206719612677092911122.0004c5a365236cacb31f9" target="_black">View in Google Maps</a>
    //                 </div>
    //                 <h2 className="row title">Alapuzza</h2>
    //                 <div className="row date">19th March 2022</div>
    //                 <div className="row summary">Brace up for an mesmarizing tour on green lakes of the backwaters, spread across a green landscape of scenic Kerala.</div>
    //             </div>
    //         </div>
    //     </div>
    // );
}