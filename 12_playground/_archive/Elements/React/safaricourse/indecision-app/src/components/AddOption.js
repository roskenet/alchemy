import React from 'react';

export default class AddOption extends React.Component {
  state = {
    error: undefined
  };
    // constructor(props) {
    //   super(props);
    // }
    
    handleOnSubmit = (e) => {
      e.preventDefault();
      // console.log(testing);

      const option = e.target.elements.optionText.value.trim();
      const error = this.props.handleAddOption(option);
      
      this.setState(() => ({ error }));
  
      if(!error) {
        e.target.elements.optionText.value = '';
      }
  
    }
  
    render() {
      return (
        <div>
        {this.state.error && <p className="add-option-error">{this.state.error}</p>}
        <form className="add-option" onSubmit={this.handleOnSubmit}>
          <input className="add-option__input" type="text" name="optionText"></input>
          <button className="button">Submit</button>
        </form>
        </div>
      );
    }
  }