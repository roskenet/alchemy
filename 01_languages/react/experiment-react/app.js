function App() {
  return (
    <div>
      <h1>{hello()}</h1>
      <p>Dies ist ein kleines Experiment mit JSX!</p>
      <p>Ich bin ein Paragraph!</p>
    </div>
  );
}

function hello() {
    // debugger
    return "Hello World!";
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<App />);
