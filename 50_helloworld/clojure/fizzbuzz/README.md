# FizzBuzz

A simple implementation of the FizzBuzz problem in Clojure.

## Usage

### Running in a REPL

To start a REPL, navigate to the project directory and run:

```
lein repl
```

Once in the REPL, you can use the FizzBuzz function:

```clojure
(require 'fizzbuzz.core)
(fizzbuzz.core/fizzbuzz 15)
```

Or, you can switch to the fizzbuzz.core namespace and call the function directly:

```clojure
(ns fizzbuzz.core)
(fizzbuzz 15)
```

### Running from the command line

To run the program from the command line:

```
lein run [number]
```

Where `[number]` is an optional argument specifying how high to count (defaults to 100 if not provided).

## License

Copyright © 2023

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.