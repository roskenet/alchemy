import {Layout, Row, Col} from "antd";
import NavigationLinks from "../Elements/NavigationLinks";
import {useEffect} from "react";

const {Content, Header, Footer} = Layout;

function About() {

  useEffect(() => {
    return () => {
      console.log('Leaving the About Page!');
    }
  }, [])

  return (
      <div>
        <Layout>
          <Header style={{color: '#ffffff'}}>Willkommen auf dieser grossartigen Seite!</Header>
            <Content style={{margin: '24px 48px 0'}}>
              <Row>
                <Col span={12}><h1>Hello World!</h1></Col>
                <Col span={12}><p>Another column.</p></Col>
              </Row>
            </Content>
          <Footer><NavigationLinks/></Footer>
        </Layout>
      </div>
  );
}

export default About;
