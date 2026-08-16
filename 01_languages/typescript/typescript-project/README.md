# TypeScript HelloWorld Example

This is a simple TypeScript HelloWorld example to get started with TypeScript development.

## Project Structure

```
typescript/
├── src/
│   └── hello.ts          # HelloWorld TypeScript source file
├── dist/                 # Compiled JavaScript output (created after build)
├── tsconfig.json         # TypeScript configuration
├── package.json          # Project dependencies and scripts
└── README.md            # This file
```

## What's Included

The `hello.ts` file demonstrates several TypeScript features:
- **Functions with type annotations**: A simple `greet()` function
- **Classes**: A `Greeter` class with private properties
- **Arrays and type inference**: Working with typed arrays
- **Interfaces**: Defining custom types for objects
- **Modern JavaScript features**: Arrow functions, template literals, etc.

## Prerequisites

Make sure you have Node.js and npm installed on your system.

## Getting Started

### 1. Install Dependencies

If you haven't already, install the project dependencies:

```bash
npm install
```

### 2. Build the TypeScript Code

Compile the TypeScript code to JavaScript:

```bash
npm run build
```

This will compile `src/hello.ts` to `dist/hello.js`.

### 3. Run the Compiled Code

Execute the compiled JavaScript:

```bash
npm start
```

### 4. Build and Run in One Command

For convenience, you can build and run in one command:

```bash
npm run dev
```

## Expected Output

When you run the HelloWorld example, you should see output similar to:

```
Hello, World!
Hello, TypeScript Developer!
Welcome, Felix!
Sum of numbers: 15
Person: Alice, Age: 30
```

## TypeScript Configuration

The `tsconfig.json` file configures the TypeScript compiler with:
- **Target**: ES2020 (modern JavaScript)
- **Module**: CommonJS (Node.js compatible)
- **Strict mode**: Enabled for better type safety
- **Source directory**: `src/`
- **Output directory**: `dist/`

## Next Steps

Now that you have a working TypeScript setup, you can:
1. Modify `src/hello.ts` to experiment with TypeScript features
2. Create additional `.ts` files in the `src/` directory
3. Explore TypeScript's type system, generics, decorators, and more
4. Add testing frameworks like Jest
5. Consider using ts-node for direct TypeScript execution without compilation

## Useful Commands

- `npm run build` - Compile TypeScript to JavaScript
- `npm start` - Run the compiled JavaScript
- `npm run dev` - Build and run in one command
- `tsc --watch` - Watch mode (recompile on file changes)

## Learn More

- [TypeScript Official Documentation](https://www.typescriptlang.org/docs/)
- [TypeScript Handbook](https://www.typescriptlang.org/docs/handbook/intro.html)
- [TypeScript Playground](https://www.typescriptlang.org/play)

Happy coding! 🚀

