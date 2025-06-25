import React, {useEffect, useState} from 'react';
import {Button, Layout} from "antd";
import NavigationLinks from "../Elements/NavigationLinks";

const { Content } = Layout;

function Counter() {
  const [count, setCount] = useState(0);

  // Similar to componentDidMount and componentDidUpdate:
  useEffect(() => {
    document.title = `You clicked ${count} times`;
  });

  return (
      <div>
        <Layout>
          <Content style={{margin: '24px 16px 0'}}>
            <h1> Hello World! </h1>
            <p>Dies ist ein Test! Hydrogen</p>
            <Button onClick={() => setCount(count+1)}>Click me!</Button>
            <p>Count is now: {count}</p>
            <NavigationLinks />
          </Content>
        </Layout>
      </div>
  );
}

export default Counter;
