package com.expense.master.service.impl;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.expense.master.model.mongod.collection.Counters;
import com.expense.master.model.mongod.collection.ExpenseRequest;
import com.expense.master.model.mongod.repository.ExpenseRepository;
import com.expense.master.service.ExpenseService;




@Component("ExpenseService")
@Transactional
public class ExpenseServiceImpl implements ExpenseService{
	
	private static Logger logger = LoggerFactory.getLogger(ExpenseServiceImpl.class);

	
	@Autowired
	private MongoOperations mongo;
	
	@Autowired
	private ExpenseRepository expenseRepo;
	
	
	@Async
	@Override
	public Future<ExpenseRequest> saveExpense(ExpenseRequest expense) {
		
		logger.info("BEGIN METHOD OF SAVEEXPENSE", expense);
		
		expense.setId(getNextSequence("expense"));
		
		ExpenseRequest expenseSavedData = expenseRepo.save(expense);
		
		logger.info("END METHOD OF SAVEEXPENSE", expenseSavedData);
		
		return new AsyncResult<ExpenseRequest>(expenseSavedData);
	}
	
	public long getNextSequence(String collectionName) {
		Counters counter = mongo.findAndModify(query(where("id").is(collectionName)), new Update().inc("seq", 1), options().returnNew(true),
				Counters.class);
		return counter.getSeq();
	}

	@Override
	public List<ExpenseRequest> listOfAllExpenses() {
		List<ExpenseRequest> listofExpense = expenseRepo.findAll();
		logger.info("BEGIN :", listofExpense);
		return listofExpense;
	}
	
	
	}


