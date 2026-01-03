const User = {
    name: 'Felix',
    city: 'Berlin'
};

const newUser = {
    age: 45,
    ...User,
    city: 'Germany'
};

let myName: string = 'Felix';

myName = 'Another';

export default User;