console.log('App.js is running!')

const app = {
  title: 'Indecision App',
  subtitle: 'This is my subtitle',
  options: []
};

const onFormSubmit = (e) => {
  e.preventDefault();

  const option = e.target.elements.option.value;

  if(option) {
    app.options.push(option);
    e.target.elements.option.value = '';
    renderApp();
  }
  console.log('On Form submit');
};

// JSX - JavaScript XML

const removeAll = () => {

  app.options = [];
  renderApp();

};

const makeDecision = () => {

  const randomNum = Math.floor(Math.random() * app.options.length);
  const option = app.options[randomNum];
  alert(option);

};

const appRoot = document.getElementById('app');

const numbers = [55, 101, 1000];

const renderApp = () => {

  const template = (
    <div>
      <h1>{app.title}</h1>
      {app.subtitle && <p>{app.subtitle}</p>}
      {app.options.length > 0 ?  
        <p>These are your options: {app.options[0]}, {app.options[1]}</p> :
        <p>No options.</p>
        }
        
        <p>{app.options.length}</p>
        <button disabled={app.options.length === 0} onClick={makeDecision}>What should I do?</button>
        <button onClick={removeAll}>Remove all</button>
        {
         numbers.map((number) => {
           return <p key={number}>Number: {number}</p>;
         })
        }
        <ol>
          {
            app.options.map((option) => {
              return <li key={option}>{option}</li>
            })
          }
        </ol>
        <form onSubmit={onFormSubmit}>
          <input type="text" name="option"/>
          <button>Add Option</button>
        </form>
    </div>
  );

  ReactDOM.render(template, appRoot);

};

renderApp();