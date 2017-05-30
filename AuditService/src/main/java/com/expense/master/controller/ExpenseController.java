package com.expense.master.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expense.master.exception.DataNotFoundException;
import com.expense.master.model.mongod.collection.ExpenseRequest;
import com.expense.master.service.ExpenseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/service")
@Api(value = "Expense Master Service")
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;

	private static Logger logger = LoggerFactory.getLogger(ExpenseController.class);

	@RequestMapping(value = "/createExpense", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Create Expense Request", notes = "Create Expense", response = ExpenseRequest.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Expense Service Successfully", response = ExpenseRequest.class),
			@ApiResponse(code = 400, message = "Invalid input provided"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })

	@CrossOrigin
	public ExpenseRequest create(@RequestBody @Validated ExpenseRequest expense, BindingResult expenseErrors,
			HttpServletRequest request)
					throws InterruptedException, ExecutionException, TimeoutException, BindException {

		logger.info("Initiating Expense Service Request  [ " + expense.toString() + " ] ");

		if (expenseErrors.hasErrors()) {
			throw new BindException(expenseErrors);
		}
		Future<ExpenseRequest> expenseResponse = expenseService.saveExpense(expense);

		ExpenseRequest expenseData = expenseResponse.get();

		if (expenseData == null) {
			throw new DataNotFoundException("Expense ", " unable to Create", "Request Not found");
		}

		return expenseData;
	}
	
	
	@RequestMapping(value = "/listofAllExpenses", method = RequestMethod.GET,produces = "application/json")
	@ApiOperation(value = "Get List Of Expenses", notes = "Get List Of All Expenses")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Expense Service Successfully", response = ExpenseRequest.class),
			@ApiResponse(code = 400, message = "Invalid input provided"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })

	@CrossOrigin
	public List<ExpenseRequest> getListOfAllExpenses(
			HttpServletRequest request)
					throws InterruptedException, ExecutionException, TimeoutException, BindException {

		logger.info("Initiating Expense Service Request  [ " + request.toString() + " ] ");

		List<ExpenseRequest> expenseResponse = expenseService.listOfAllExpenses();

		if (expenseResponse == null) {
			throw new DataNotFoundException("list of Expenses ", " unable to get", "Request Not found");
		}

		return expenseResponse;
	}

}
