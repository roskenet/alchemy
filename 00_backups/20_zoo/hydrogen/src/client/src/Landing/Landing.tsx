import NavigationLinks from "../Elements/NavigationLinks";
import {Layout} from "antd";

const { Content } = Layout;

function Landing() {

  return (
      <div>
        <Layout>
          <Content style={{margin: '24px 16px 0'}}>
            <h1> Hello World! </h1>
            <p>Dies ist die Landing Page der Anwendung!</p>
            <NavigationLinks />
          </Content>
        </Layout>
      </div>
  );
}

export default Landing;
