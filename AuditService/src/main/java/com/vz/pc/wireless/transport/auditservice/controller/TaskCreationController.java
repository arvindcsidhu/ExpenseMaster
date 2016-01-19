package com.vz.pc.wireless.transport.auditservice.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vz.pc.wireless.transport.auditservice.exception.DataNotFoundException;
import com.vz.pc.wireless.transport.auditservice.model.mongod.collection.TaskInst;
import com.vz.pc.wireless.transport.auditservice.service.TaskCreationService;
import com.vz.pc.wireless.transport.auditservice.validator.TaskCreationValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;




@RestController
@RequestMapping("/service")
@Api(value = "Task Logging Service")
public class TaskCreationController {
	
	
	@Autowired
	TaskCreationValidator auditEventValidator;
	
	@Autowired
	TaskCreationService taskCreationService;
	
	
	private static Logger logger = LoggerFactory.getLogger(TaskCreationController.class);

	@RequestMapping(value = "/tasks", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Create Wireless Transport Order", notes = "Create PC Wireless Transport order", response = TaskInst.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Audit Service Successfully", response = TaskInst.class),
	@ApiResponse(code = 400, message = "Invalid input provided"), @ApiResponse(code = 500, message = "Internal Server Error"), })

	@CrossOrigin
	public TaskInst create(@RequestBody @Validated TaskInst taskInst, BindingResult auditErrors, HttpServletRequest request)
			throws InterruptedException, ExecutionException, TimeoutException, BindException {

		logger.info("Initiating Audit Service Request  [ " + taskInst.toString() + " ] ");

		ValidationUtils.invokeValidator(auditEventValidator, taskInst, auditErrors);
		if (auditErrors.hasErrors()) {
			throw new BindException(auditErrors);
		}
		 taskCreationService.transformTaskInst(taskInst);
		Future<TaskInst> auditResponse = taskCreationService.createTask(taskInst);
		
		TaskInst events = auditResponse.get();
		
		if (events == null) {
			throw new DataNotFoundException("Order ", " unable to Create", "Request Not found");
		}
		
		return events;
	}
	
	
	@RequestMapping(value = "/taskService/{pcOrderNumber}", method = RequestMethod.GET)
	@ApiOperation(value = "Create Wireless Transport Order", notes = "Create PC Wireless Transport order", response = TaskInst.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Audit Service Successfully", response = TaskInst.class),
	@ApiResponse(code = 400, message = "Invalid input provided"), @ApiResponse(code = 500, message = "Internal Server Error"), })

	@CrossOrigin
	public List<TaskInst> getTaskList(@RequestParam @Validated String pcOrderNumber, HttpServletRequest request)
			throws InterruptedException, ExecutionException, TimeoutException, BindException {

		logger.info("Initiating Task List Service Request  [ " + pcOrderNumber + " ] ");
		List<TaskInst>  taskLisntDet = null; 
		
		Future<List<TaskInst>> taskInstList = taskCreationService.getTaskList(pcOrderNumber);
		if(Optional.ofNullable(taskInstList).isPresent()){
			taskLisntDet = taskInstList.get();
		}else{
			logger.info("No Tasks found for the order number ["+pcOrderNumber+"]");
		}
		
		return taskLisntDet;
	}
	
	@RequestMapping(value = "/load/task", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Create Wireless Transport Order", notes = "Create PC Wireless Transport order", response = TaskInst.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Audit Service Successfully", response = TaskInst.class),
	@ApiResponse(code = 400, message = "Invalid input provided"), @ApiResponse(code = 500, message = "Internal Server Error"), })

	@CrossOrigin
	public String loadTask(@RequestBody @Validated TaskInst taskInst, BindingResult auditErrors, HttpServletRequest request)
			throws InterruptedException, ExecutionException, TimeoutException, BindException {

		logger.info("Initiating Audit Service Request  [ " + taskInst.toString() + " ] ");
		
	//	ValidationUtils.invokeValidator(auditEventValidator, taskInst, auditErrors);
		if (auditErrors.hasErrors()) {
			throw new BindException(auditErrors);
		}
		 taskCreationService.transformTaskInst(taskInst);
		//Future<TaskInst> auditResponse = taskCreationService.createTask(taskInst);
		
		//TaskInst events = auditResponse.get();
				
		return "Task Created Successfully";
	}
	
	@RequestMapping(value = "/update/task", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Create Wireless Transport Order", notes = "Create PC Wireless Transport order")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Audit Service Successfully", response = TaskInst.class),
	@ApiResponse(code = 400, message = "Invalid input provided"), @ApiResponse(code = 500, message = "Internal Server Error"), })

	@CrossOrigin
	public void updateTask(@RequestBody @Validated TaskInst taskInst, BindingResult auditErrors, HttpServletRequest request)
			throws InterruptedException, ExecutionException, TimeoutException, BindException {

		logger.info("Initiating Update task Service Request  [ " + taskInst.toString() + " ] ");

		if (auditErrors.hasErrors()) {
			throw new BindException(auditErrors);
		}
		 taskCreationService.initialTaskUpdate(taskInst);
	
	}

	@RequestMapping(value = "/create/utetask", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Create Wireless Transport Order", notes = "Create PC Wireless Transport order")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Audit Service Successfully", response = TaskInst.class),
	@ApiResponse(code = 400, message = "Invalid input provided"), @ApiResponse(code = 500, message = "Internal Server Error"), })

	@CrossOrigin
	public void createUTETask(@RequestBody @Validated TaskInst taskInst, BindingResult auditErrors, HttpServletRequest request)
			throws InterruptedException, ExecutionException, TimeoutException, BindException {

		logger.info("Initiating UTE task Service Request  [ " + taskInst.toString() + " ] ");

		if (auditErrors.hasErrors()) {
			throw new BindException(auditErrors);
		}
		 taskCreationService.createUTETask(taskInst);
	
	}

	
	
}
