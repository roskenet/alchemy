import {useState} from "react";

const DoSomething = () => {
    const [ count, setCount ] = useState(0);

    return (
        <div>
            <h2>DoSomething</h2>
            <p>Count ist nun: {count}</p>
        </div>
    )
}

export default DoSomething;
