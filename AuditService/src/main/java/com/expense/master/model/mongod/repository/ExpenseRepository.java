package com.expense.master.model.mongod.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.expense.master.model.mongod.collection.ExpenseRequest;

public interface ExpenseRepository extends MongoRepository<ExpenseRequest, Long> {
	
	public List<ExpenseRequest> findBydate(Date date);

}
