function App() {
  return (
    <div>
      <h1>{hello()}</h1>
      <p>Dies ist ein kleines Experiment mit JSX!</p>
    </div>
  );
}

function hello() {
    return "Hello World!";
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<App />);

