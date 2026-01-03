const CountStream = require('./countstream');
const countStream = new CountStream('Willkommen');
const http = require('http');

http.get('http://felix-roske.de', function(res) {
    res.pipe(countStream);
});

countStream.on('total', function(count) {
    console.log('Total matches:', count);
});
