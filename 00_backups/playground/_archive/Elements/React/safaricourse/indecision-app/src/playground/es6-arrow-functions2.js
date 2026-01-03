const multiplier = {
    // numbers -array of numbers
    // multiplyBy - single number
    // multiply returns new array
    numbers: [1, 2, 3],
    multiplyBy: 2,
    multiply() { // ES6 syntax
      return this.numbers.map((num) => num * this.multiplyBy); 
    }
};

console.log(multiplier.multiply());