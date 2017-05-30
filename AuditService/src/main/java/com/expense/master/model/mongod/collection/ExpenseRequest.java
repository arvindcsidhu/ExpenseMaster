package com.expense.master.model.mongod.collection;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "expense")
public class ExpenseRequest {

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getExpensePaidBy() {
		return expensePaidBy;
	}

	public void setExpensePaidBy(String expensePaidBy) {
		this.expensePaidBy = expensePaidBy;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@org.springframework.data.annotation.Id
	private long Id;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	private String expenseName;

	private Date date;

	private String expensePaidBy;

	private BigDecimal amount;

}
