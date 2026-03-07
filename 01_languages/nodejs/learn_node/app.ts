const http = require('http');

function helloWorld(req, res) {
    console.log(req, res);
}

http.createServer(helloWorld).listen(3000);
