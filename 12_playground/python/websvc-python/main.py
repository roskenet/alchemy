from flask import Flask, request
from hello_websvc import hello

app = Flask(__name__)


@app.route('/post', methods=['POST'])
def index():
    body = request.get_json()

    return hello.hello_world('World')


if __name__ == '__main__':
    app.run(debug=True)
