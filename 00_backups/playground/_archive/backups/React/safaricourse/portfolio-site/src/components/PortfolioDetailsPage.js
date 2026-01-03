import React from 'react';

const PortfolioDetailsPage = (props) => (
    <div>
        <h1>A Portfolio</h1>
        <p>You see Portfolio {props.match.params.id}</p>
    </div>
);

export default PortfolioDetailsPage;