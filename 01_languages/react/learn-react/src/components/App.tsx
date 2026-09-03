import React, {useState} from "react";

type Props = {
  heading: string;
}

export function App({heading}: Props) {
  const [isVisible, setVisible] = useState(true);

  if (isVisible) {
    return (
        <>
          <h1>My React App!</h1>
          <p>This is a test!</p>
          <p>The heading props is: {heading}</p>
          <button onClick={() => {setVisible(false)}}>Try me!</button>
        </>
    )
  } else {
    return (
        <>
          <h1>This component is not visible!</h1>
          <button onClick={() => {setVisible(true)}}>Show it!</button>
        </>
    )
  }
}

export default App;
