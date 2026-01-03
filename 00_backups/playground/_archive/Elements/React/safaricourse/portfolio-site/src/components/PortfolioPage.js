import React from 'react';
import { Link } from 'react-router-dom';

const PortfolioPage = () => (
    <div>
        <h1>Portfolio</h1>
        <Link to="/portfolio/1">Portfolio Eins</Link>
        <Link to="/portfolio/2">Portfolio Zwei</Link>
        <Link to="/portfolio/42">Portfolio Drei</Link>
    </div>
);

export default PortfolioPage;