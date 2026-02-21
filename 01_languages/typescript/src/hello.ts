/**
 * A simple HelloWorld example in TypeScript
 */

// Define a simple greeting function
function greet(name: string): string {
    return `Hello, ${name}!`;
}

// Define a class example
class Greeter {
    private greeting: string;

    constructor(message: string) {
        this.greeting = message;
    }

    greetPerson(person: string): void {
        console.log(`${this.greeting}, ${person}!`);
    }
}

// Main execution
function main(): void {
    // Simple function call
    console.log(greet("World"));
    console.log(greet("TypeScript Developer"));

    // Class usage
    const greeter = new Greeter("Welcome");
    greeter.greetPerson("Felix");

    // Type demonstration
    const numbers: number[] = [1, 2, 3, 4, 5];
    const sum = numbers.reduce((acc, curr) => acc + curr, 0);
    console.log(`Sum of numbers: ${sum}`);

    // Interface example
    interface Person {
        name: string;
        age: number;
    }

    const person: Person = {
        name: "Alice",
        age: 30
    };

    console.log(`Person: ${person.name}, Age: ${person.age}`);
}

// Run the main function
main();

