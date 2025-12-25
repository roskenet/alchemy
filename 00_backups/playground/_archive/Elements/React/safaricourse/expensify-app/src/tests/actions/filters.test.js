import moment from 'moment';
import { setStartDate, setEndDate, setTextFilter, sortByDate, sortByAmount, setSortBy } from '../../actions/filters';

test('shoudl generate setSTartDate', () => {
    const action = setStartDate(moment(0));
    expect(action).toEqual({
        type: 'SET_START_DATE',
        date: moment(0)
    })
});

test('should generate setEndDate', () => {
    const action = setEndDate(moment(0));
    expect(action).toEqual({
        type: 'SET_END_DATE',
        date: moment(0)
    })
});

test('text filter', () => {
    const action = setTextFilter('SomeText');
    expect(action).toEqual({
        type: 'SET_TEXT_FILTER',
        text: 'SomeText'
    })
});

test('text default filter', () => {
    const action = setTextFilter();
    expect(action).toEqual({
        type: 'SET_TEXT_FILTER',
        text: ''
    })
});

test('sortByDate filter', () => {
    const action = setSortBy('date');
    expect(action).toEqual({
        type: 'SORT_BY',
        value: 'date'
    })
});

test('sortByAmount filter', () => {
    const action = sortByAmount();
    expect(action).toEqual({
        type: 'SORT_BY',
        value: 'amount'
    })
});