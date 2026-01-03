import './App.css';
import {Button} from "antd";
import {useState} from "react";

const Fetch = () => {
    const [theState, setTheState] = useState({"name": "Unknown"});

const doSomething = () => {
    console.log("Ein Click!");

    fetch('http://oxygen.192-168-49-2.nip.io/api/name/some%20body')
        .then(response => response.json())
        .then(result => setTheState({"name": result.value}))
        .catch(error => console.error(error));
}

    const doSomethingElse = () => {
        setTheState({"name": "Do something else"})
    }
    return (
        <div className="App">
            <header className="App-header">
                <p>Dies is a real Killer App!</p>
                <Button onClick={doSomething}>Click me!</Button>
                <Button onClick={doSomethingElse}>Set something else!</Button>
                <p>The State is: {theState.name}</p>
            </header>
        </div>
    );
}

export default Fetch;
