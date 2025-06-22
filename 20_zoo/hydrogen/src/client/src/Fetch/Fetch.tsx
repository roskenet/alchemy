import {Button} from "antd";
import {useState} from "react";
import NavigationLinks from "../Elements/NavigationLinks";

const Fetch = () => {
  const [theState, setTheState] = useState({"name": "Unknown", "email": "Unknown"});

  // const doSomething = () => {
  //   console.log("Ein Click!");
  //
  //   fetch('http://oxygen.192-168-49-2.nip.io/api/name/some%20body')
  //   .then(response => response.json())
  //   .then(result => setTheState({"name": result.value}))
  //   .catch(error => console.error(error));
  // //  .then(result => console.log(result))
  // //      .catch(error => console.error(error));
  //
  // }

    const callAPIMe= () => {
        console.log("Call auf /api/me");

        fetch('http://localhost:8080/api/me')
            .then(response => response.json())
            // .then(result => setTheState({"name": result.name}))
            .then(result => setTheState(result))
            .catch(error => console.error(error));
        // .then(result => console.log(result))
        //     .catch(error => console.error(error));

    }

  return (
      <div>
          <p>Dies is a real Killer App!</p>
          <Button onClick={callAPIMe}>Click me!</Button>
          <p>The Name is: {theState.name}</p>
          <p>The Email is: {theState.email}</p>
          <NavigationLinks/>
      </div>
  );
}

export default Fetch;