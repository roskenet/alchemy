import React from 'react';
import { Layout } from 'antd';
import Hello from './Hello';


const { Header, Content, Footer } = Layout;

export function HomePage({ headerText = 'empty', contentText = 'empty' }) {
    return (

            <Hello />
    
    );
}