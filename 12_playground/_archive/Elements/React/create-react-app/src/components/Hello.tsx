import React from 'react';
import { Divider , Row, Col, Alert, Button } from 'antd';

export default class Hello extends React.Component {
    state = {
        editedString: 'Nichts!',
        response: ''
    };

    changeEditedString = (e: any) => {
        this.setState({
            editedString: e.target.value
        });
    };

    onDoSomething = (e: any) => {
        fetch('http://localhost:8080/answer')
        .then(res => res.json())
        .then((data) => {
            this.setState({response: data.theAnswer})
        })
        .catch(console.log)


        // console.log('DoSomething')
    };

    render() {
        return (
            <div>
                <h1>Willkomen</h1>
                <p>{<Alert message={this.state.response} type="info" />}</p>
                <Row>
                    <Col span={24}><h1>Software Engineering</h1>
                    <Divider orientation="left">Einführung</Divider>
                    <p>Und dies ist der erste Absatz</p>
                    <Button onClick={this.onDoSomething}>Do Something!</Button>
                    </Col>
                </Row>
            </div>
        )
    }
}