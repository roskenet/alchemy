import {Button, Checkbox, Form, Input} from "antd";
import {useState} from "react";
import NavigationLinks from "../Elements/NavigationLinks";

const FormExample = () => {
  const [something, setSomething] = useState({"name": "Unknown", "number": 42});

  const onFinish = () => {
    // e.preventDefault()
    console.log("Ein Click!");

    // fetch('http://hydrogen.192-168-49-2.nip.io/api/something', {
    fetch('http://hydrogen/api/something', {
      method: 'POST',
      body: JSON.stringify(something),
      headers: {'Content-Type': 'application/json'},
    })
    .then(response => response.json())
    // .then(result => setTheState({"name": result.value}))
    // .catch(error => console.error(error));
    // .then(result => console.log(result))
    //     .catch(error => console.error(error));
  }

  return (
      <>
          <h1>Playing with Forms:</h1>
        <Form
        name="basic"
        labelCol={{ span: 8 }}
        wrapperCol={{ span: 16 }}
        initialValues={{ remember: true }}
        onFinish={onFinish}
        // onFinishFailed={onFinishFailed}
        autoComplete="off"
        >
        <Form.Item
            label="Username"
            name="something[name]"
            rules={[{ required: true, message: 'Please input your username!' }]}
        >
          <Input onChange={e => setSomething({...something, name: e.target.value})}/>
        </Form.Item>

        <Form.Item name="remember" valuePropName="checked" wrapperCol={{ offset: 8, span: 16 }}>
          <Checkbox>Remember me</Checkbox>
        </Form.Item>

        <Form.Item wrapperCol={{ offset: 8, span: 16 }}>
          <Button type="primary" htmlType="submit">
            Submit
          </Button>
        </Form.Item>
      </Form>
        <NavigationLinks/>
      </>
  );
}

export default FormExample;
