import React from 'react';

const FlxElement = (props) => {
    return (
        <div>
            <h1>This is the String: {props.text}.</h1>
        </div>
    );
};

const myString: String = "Hallo Welt";

class MyComp extends React.Component {
    render() {
        return (
            <div>
            <h1>This is mycomp!</h1>
                <p>And now we call FlxElement:</p>
                <FlxElement />
            </div>
        );
    }
}

export default MyComp;