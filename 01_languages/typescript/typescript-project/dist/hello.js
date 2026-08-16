"use strict";
/**
 * A simple HelloWorld example in TypeScript
 */
// Define a simple greeting function
function greet(name) {
    return `Hello, ${name}!`;
}
// Define a class example
class Greeter {
    constructor(message) {
        this.greeting = message;
    }
    greetPerson(person) {
        console.log(`${this.greeting}, ${person}!`);
    }
}
// Main execution
function main() {
    // Simple function call
    console.log(greet("World"));
    console.log(greet("TypeScript Developer"));
    // Class usage
    const greeter = new Greeter("Welcome");
    greeter.greetPerson("Felix");
    // Type demonstration
    const numbers = [1, 2, 3, 4, 5];
    const sum = numbers.reduce((acc, curr) => acc + curr, 0);
    console.log(`Sum of numbers: ${sum}`);
    const person = {
        name: "Alice",
        age: 30
    };
    console.log(`Person: ${person.name}, Age: ${person.age}`);
}
// Run the main function
main();
