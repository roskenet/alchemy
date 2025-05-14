import moment from 'moment';
import filtersReducer from '../../reducers/filters';

test('Should setup default filter values', () => {
    const state = filtersReducer(undefined, { type: '@@INIT' });
    expect(state).toEqual({
        text: '',
        sortBy: 'date',
        startDate: moment().startOf('month'),
        endDate: moment().endOf('month')
    })
});

test('Should set sortBy to amount', () => {
    const state = filtersReducer(undefined, {
        type: 'SORT_BY',
        value: 'amount'
    });
    expect(state.sortBy).toBe('amount');
});

test('Should set sortBy to date', () => {
    const currentState = {
        text: '',
        startDate: undefined,
        endDate: undefined,
        sortBy: 'amount'
    };
    const action = { type: 'SORT_BY', value: 'date'};
    const state = filtersReducer(currentState, action);
    expect(state.sortBy).toBe('date');
});

test('Should set text filter', () => {
    const state = filtersReducer(undefined, { type: 'SET_TEXT_FILTER', text: 'ABC'});
    expect(state.text).toBe('ABC');
});

test('Should set startDate filter', () => {
    const state = filtersReducer(undefined, { type: 'SET_START_DATE', date: moment(0)});
    expect(state.startDate).toEqual(moment(0));
});

test('Should set startEnd filter', () => {
    const state = filtersReducer(undefined, { type: 'SET_END_DATE', date: moment(0)});
    expect(state.endDate).toEqual(moment(0));
});

