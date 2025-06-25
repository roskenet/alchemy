import React from 'react';
import { Routes, Route } from "react-router-dom";
import './App.less';
import About from "./About/About";
import Counter from "./Counter/Counter";
import Landing from "./Landing/Landing";
import Fetch from "./Fetch/Fetch";
import FormExample from "./Form/FormExample";

function App() {
  return (
      <div>
        <Routes>
          <Route path={'/'} element={<Landing/>}/>
          <Route path={'/about'} element={<About/>}/>
          <Route path={'/counter'} element={<Counter/>}/>
          <Route path={'/fetch'} element={<Fetch/>}/>
          <Route path={'/form'} element={<FormExample/>}/>
        </Routes>
      </div>
  );
}

export default App;
