// Object Desctructuring


// const person = {
//     name: 'Felix',
//     age: 45,
//     location: {
//         city: 'Berlin',
//         temp: 18
//     }
// };

// // const name = person.name;
// // const age = person.age;

// const { name, age } = person;

// console.log(`${name} is ${age}`);

// if(person.location.city && person.location.temp) {
//     console.log(`It's ${person.location.temp} in ${person.location.city}.`)
// }

// const book = {
//     title: 'Ego is the Enemy',
//     author: 'Ryan Holiday',
//     publisher: {
//         name: 'Penguin'
//     }
// }


// const { name: publisherName = 'Self-Published'} = book.publisher;



// console.log(publisherName);

// Array Desctructuring

// const address = ['1299 S Juniper Street', 'Philadelphia', 'PA', '19415'];

// const [, city, state] = address;

// console.log(`You are in ${city} ${state}`);


const item = ['Coffee (hot)', '$2.00', '$2.50', '$2.75'];

const [beverage, ,amount] = item;

console.log(`A medium ${beverage} costs ${amount}`);