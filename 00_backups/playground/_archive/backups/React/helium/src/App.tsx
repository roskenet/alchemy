import React from 'react';
import { Button } from 'antd';
import './App.css';
import Coolstuff from "./components/coolstuff";

// This is my reference project

const App = () => {
  return (
    <div className="App">
      <header className="App-header">
          <h1>Hallo!</h1>
          <p>Dies ist der ultimative antd-Test...</p>
          <Button>Push the button</Button>
          <Coolstuff name='Felix'></Coolstuff>
      </header>
    </div>
  );
}

export default App;
