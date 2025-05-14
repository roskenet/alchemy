import React from 'react';
import { shallow } from 'enzyme';
import moment from 'moment';
import ExpenseForm from '../../components/ExpenseForm';
import expenses from '../fixture/expenses';

test('Should render ExpenseForm correctly', () => {
    const wrapper = shallow(<ExpenseForm />);
    expect(wrapper).toMatchSnapshot();
});

test('Should render expense form with data', () => {
    const wrapper = shallow(<ExpenseForm expense={expenses[0]} />);
    expect(wrapper).toMatchSnapshot();
});

test('Should render an error for invalid from submission', () => {
    const wrapper = shallow(<ExpenseForm />);
    expect(wrapper).toMatchSnapshot();

    wrapper.find('form').simulate('submit', {
        preventDefault: () => { }
    });

    expect(wrapper.state('errorState').length).toBeGreaterThan(0);
    expect(wrapper).toMatchSnapshot();
})

test('Should set description on input change', () => {
    const value = 'New description';
    const wrapper = shallow(<ExpenseForm />);
    wrapper.find('input').at(0).simulate('change', {
        target: {value}
    });
    expect(wrapper.state('description')).toBe(value);
});

test('Should set note on input change', () => {
    const value = 'This is a note.';
    const wrapper = shallow(<ExpenseForm />);
    wrapper.find('textarea').simulate('change', {
        target: {value}
    });
    expect(wrapper.state('note')).toBe(value);
});

test('Should allow changes to amount', () => {
    const value = '23.50';
    const wrapper = shallow(<ExpenseForm />);
    wrapper.find('input').at(1).simulate('change', {
        target: {value}
    });

    expect(wrapper.state('amount')).toBe('23.50');
})

test('Should not allow changes to amount', () => {
    const value = '12.122';
    const wrapper = shallow(<ExpenseForm />);
    wrapper.find('input').at(1).simulate('change', {
        target: {value}
    });

    expect(wrapper.state('amount')).toBe('');
});

test('should call onSubmit for valid form', () => {
    const onSubmitSpy = jest.fn();
    const wrapper = shallow(<ExpenseForm expense={expenses[0]}
        onSubmit={onSubmitSpy} />);
    wrapper.find('form').simulate('submit', {
        preventDefault: () => { }
    });

    expect(wrapper.state('errorState')).toBe('');
    expect(onSubmitSpy).toHaveBeenLastCalledWith({
        description: expenses[0].description,
        amount: expenses[0].amount,
        note: expenses[0].note,
        createdAt: expenses[0].createdAt
    }
    );
});

test('should set new daet', () => {
    const now = moment();
    const wrapper = shallow(<ExpenseForm />);
    
    wrapper.find('SingleDatePicker').prop('onDateChange')(now);
    
    expect(wrapper.state('createdAt')).toEqual(now);
})

test('should set calendar focused', () => {
    const wrapper = shallow(<ExpenseForm />);

    wrapper.find('SingleDatePicker').prop('onFocusChange')({ focused: true });

    expect(wrapper.state('calendarFocused')).toEqual(true);
})