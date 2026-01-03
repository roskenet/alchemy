import React from 'react';
import ReactDOM from 'react-dom';
import MyComp  from './playground/myclass';

import 'normalize.css/normalize.css';
import './styles/styles.scss';

const App = (props) => (
    <div>
        <h1>Hello World!</h1>
        <p>This is the App!</p>
    </div>
);

ReactDOM.render(<App />, document.getElementById('app'));
