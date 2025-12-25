const path = require('path');

module.exports = {
    entry: './src/app.tsx',
    output: {
        path: path.join(__dirname, 'public'),
        filename: 'bundle.js'
    },
    module: {
        rules: [{
            use: ['babel-loader',
                  'ts-loader'],
            test: /\.[jt]sx?$/,
            exclude: /node_modules/
        }, {
            test: /\.s?css$/,
            use: [
                'style-loader',
                'css-loader',
                'sass-loader'
            ]
        }
    ]
    },
    resolve: {
        extensions: [ '.tsx', '.jsx', '.ts', '.js' ],
    },
    devtool: 'cheap-module-eval-source-map',
    devServer: {
        contentBase: path.join(__dirname, 'public')
    }
};

