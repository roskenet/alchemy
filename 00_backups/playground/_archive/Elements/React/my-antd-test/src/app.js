// import { Button } from 'antd';
import { Button } from 'antd/lib/index';

class Application extends React.Component {
    render() {
        return (
            <div>
                <h1>Hello World!</h1>
                <Button>Here is a button</Button>
            </div>
        );
    }
}

ReactDOM.render(<Application />, document.getElementById('app'));