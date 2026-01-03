import * as React from "react";

class MyComponent extends React.Component<any, any> {
    constructor(props: any) {
        super(props);
        this.state = { mystring: 'Some String' }
    }
    render() {
        return (
            <div>
                <h1>Hello World!</h1>
                <p>Im State steht: {this.state.mystring}</p>
                <p>Und eine Property: {this.props.myprop}</p>
            </div>
        );
    }
}

export default MyComponent;
