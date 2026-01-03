import { createStore, combineReducers } from 'redux';
import { v4 as uuid }  from 'uuid';

const demoState = {
  expenses: [{
      id: 'someid',
      description: 'January Rent',
      note: 'This was the final payment for that address',
      amount: 62000,
      createdAt: 0
  }],
  filters: {
      text: 'rent',
      sortBy: 'amount',
      startDate: undefined,
      endDate: undefined
  }
};

// Expenses reducer

const addExpense = ({ description = '', 
    note = '', 
    amount = 0, 
    createdAt = 0 } = {}) => ({
    type: 'ADD_EXPENSE',
    expense: {
        id: uuid(),
        description,
        note,
        createdAt
    }
});

const removeExpense = ({ id }) => ({
    type: 'REMOVE_EXPENSE',
    id
});

const editExpense = (id, updates) => ({
    type: 'EDIT_EXPENSE',
    id,
    updates
});

const expensesReducerDefaultState = [];

const expensesReducer = (state = expensesReducerDefaultState, action) => {
switch (action.type) {
    case 'ADD_EXPENSE':
        return [
            ...state,
            action.expense
        ];
    case 'REMOVE_EXPENSE':
        return state.filter((/* expense*/ { id }) => action.id !== id);
    case 'EDIT_EXPENSE':
        return state.map((expense) => {
            if(expense.id === action.id) {
                return {
                    ...expense,
                    ...action.updates
                };
            } else {
                return expense;
            }
        })
    default:
        return state;
}
};

// handleDeleteOption = (optionToRemove) => {
//     this.setState((prevState) => ({
//         options: prevState.options.filter((option) => optionToRemove !== option)
//     }));

//     console.log('hto', optionToRemove);
// };

// Filters Reducer

const filtersReducerDefault = {
    text: '',
    sortBy: 'date',
    startDate: undefined,
    endDate: undefined
};

const setTextFilter = ( text = '' ) => ({
    type: 'SET_TEXT_FILTER',
    text
});

const sortByAmount = () => ({
    type: 'SORT_BY',
    value: 'amount'
});

const sortByDate = () => ({
    type: 'SORT_BY',
    value: 'date'
});

const setStartDate = ( date ) => ({ 
    type: 'SET_START_DATE',
    date
});

const setEndDate = ( date ) => ({ 
    type: 'SET_END_DATE',
    date
});

const filtersReducer = (state = filtersReducerDefault, action) => {
    switch (action.type) {
        case 'SET_TEXT_FILTER':
            return {
                ...state,
                text: action.text
            };
        case 'SORT_BY':
            return {
                ...state,
                sortBy: action.value
            };
        case 'SET_START_DATE':
            return {
                ...state,
                startDate: action.date
            };
        case 'SET_END_DATE':
            return {
                ...state,
                endDate: action.date
            };
        default:
            return state;
    }
};

// timestamps: (milliseconds)
// Jan 1st 1970 (unix epoch)

// Get visible expenses

const getVisibleExpenses = (expenses, { text, sortBy, startDate, endDate } ) => {
    return expenses.filter((expense)=> {
        const startDateMatch = typeof startDate !== 'number' || expense.createdAt >= startDate;
        const endDateMatch = typeof endDate !== 'number' || expense.createdAt <= endDate;
        const textMatch = expense.description.toLowerCase().includes(text.toLowerCase());
        // const textMatch = true;

        return startDateMatch && endDateMatch && textMatch;
    }).sort((a,b) => {
        if(sortBy === 'date') {
            return a.createdAt < b.createdAt ? 1 : -1;
        } else if (sortBy === 'amount') {
            return a.amount < b.amount ? 1 : -1;
        }       
    });
};

const store = createStore(
    combineReducers({
        expenses: expensesReducer,
        filters: filtersReducer
    })
);

store.subscribe(() => {
    const state = store.getState();
    const visibleExpenses = getVisibleExpenses(state.expenses, state.filters);
    console.log(visibleExpenses);
});

const expenseOne = store.dispatch(addExpense({ description: 'Rent', amount: 100, createdAt: -3000 }));

const expenseTwo = store.dispatch(addExpense({ description: 'Coffee', amount: 300, createdAt: -1000 }));

// store.dispatch(removeExpense({ id: expenseOne.expense.id }));

// store.dispatch(editExpense(expenseTwo.expense.id,
//     { amount: 500 }
//     ));


// store.dispatch(setTextFilter('ent'));
// store.dispatch(setTextFilter(''));
// store.dispatch(setStartDate(2000));

store.dispatch(sortByAmount());
// store.dispatch(sortByDate());

// store.dispatch(setStartDate(125));
// store.dispatch(setStartDate());

// store.dispatch(setEndDate(1250));
// store.dispatch(setEndDate());

// console.log(store.getState());

// Object spread operator

// const user = {
//     name: 'Jen',
//     age: 24
// };

// console.log({
//   ...user,
//   location: 'New York',
//   age: 27
// });
