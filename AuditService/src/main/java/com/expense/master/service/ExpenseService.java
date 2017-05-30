package com.expense.master.service;

import java.util.List;
import java.util.concurrent.Future;

import com.expense.master.model.mongod.collection.ExpenseRequest;

public interface ExpenseService {
	
	public Future<ExpenseRequest> saveExpense(ExpenseRequest expense);
	
	public List<ExpenseRequest> listOfAllExpenses();

}
