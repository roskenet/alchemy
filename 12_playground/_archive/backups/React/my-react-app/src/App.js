import React from 'react';
import { Layout } from 'antd';
import 'antd/dist/antd.css';

const { Header, Content, Footer } = Layout;

function App() {
  return (
    <div className="App">
      <Layout>
        <Header style={{ padding: 0, background: '#fff'}}>
        <h1>Hello World!</h1>
        </Header>
        <Content style={{ padding: '0 50px', marginTop: 64 }}>
        <h1>Hello World!</h1>
        <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr,
          sed diam nonumy eirmod tempor invidunt ut labore et dolore
          magna aliquyam erat, sed diam voluptua. At vero eos et accusam
          et justo duo dolores et ea rebum. Stet clita kasd gubergren,
          no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum
          dolor sit amet, consetetur sadipscing elitr, sed diam nonumy
          eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.</p>
        <p>At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd
          gubergren, no sea takimata sanctus est Lorem ipsum dolor sit
          amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr,
          sed diam nonumy eirmod tempor invidunt ut labore et
          dolore magna aliquyam.</p>
          </Content>
          <Footer>
            <p>This is a footer!</p>            
          </Footer>
       </Layout>
    </div>
  );
}

export default App;
