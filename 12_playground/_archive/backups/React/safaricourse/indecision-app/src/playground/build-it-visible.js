class VisibilityToggle extends React.Component {
    
    constructor(props) {
        super(props);
        this.handleToggleDetails = this.handleToggleDetails.bind(this);
        
        this.state = {
            showDetails: false
        };
    }

    handleToggleDetails() {
        this.setState((prevState) => {
            return {
                showDetails: !prevState.showDetails
            }
        });
    }

    render() {
        return (
            <div>
                <h1>Visibility Toggle</h1>
                <button onClick={this.handleToggleDetails}>
                    {this.state.showDetails ? 'Hide Details' : 'Show Details'}
                </button>
                {this.state.showDetails && <p>Details</p>}
            </div>
        );
    }
}

// const app = {
//    buttonText: 'Show details',
//    detailsText: 'These are the details',
//    showDetails: false,
//    toggleMe: () => {
//     if(app.showDetails) {
//         app.buttonText = 'Show details';
//         app.showDetails = false;
//     } else {
//         app.buttonText = 'Hide details';
//         app.showDetails = true;
//     }

//    console.log('Toggled');
//    renderApp();
//    }
// }

// const appRoot = document.getElementById('app');

// const renderApp = () => {
// const template = (
//     <div>
//         <h1>Visibility Toggle</h1>
//         <button onClick={app.toggleMe}>{app.buttonText}</button>
//         {app.showDetails && <p>{app.detailsText}</p>}
//     </div>
// );

ReactDOM.render(<VisibilityToggle/>, document.getElementById('app'));

// };

// renderApp();
