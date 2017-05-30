package com.vz.pc.wireless.transport.auditservice.service.impl;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

import com.google.common.base.Splitter;
import com.verizon.ginger.utewrapper.valueobject.OrderInfo;
import com.verizon.ginger.utewrapper.valueobject.TaskRequest;
import com.verizon.ginger.utewrapper.valueobject.TaskResponse;
import com.vz.pc.wireless.transport.auditservice.Enumerators.TaskStatus;
import com.vz.pc.wireless.transport.auditservice.exception.DataNotFoundException;
import com.vz.pc.wireless.transport.auditservice.model.mongod.collection.AsrMilestone;
import com.vz.pc.wireless.transport.auditservice.model.mongod.collection.Counters;
import com.vz.pc.wireless.transport.auditservice.model.mongod.collection.PcWirelessOrder;
import com.vz.pc.wireless.transport.auditservice.model.mongod.collection.TaskInst;
import com.vz.pc.wireless.transport.auditservice.model.mongod.collection.TaskTemplate;
import com.vz.pc.wireless.transport.auditservice.model.mongod.repository.AsrMilestoneRepository;
import com.vz.pc.wireless.transport.auditservice.model.mongod.repository.PcWirelessOrderRepository;
import com.vz.pc.wireless.transport.auditservice.model.mongod.repository.TaskInstRepository;
import com.vz.pc.wireless.transport.auditservice.model.mongod.repository.TaskRefDetailRepository;
import com.vz.pc.wireless.transport.auditservice.model.mongod.repository.TaskTemplateRepository;
import com.vz.pc.wireless.transport.auditservice.service.TaskCreationService;



@Component("taskCreationService")
@Transactional


public class TaskCreationServiceImpl implements TaskCreationService{
	
	private static Logger logger = LoggerFactory.getLogger(TaskCreationServiceImpl.class);

	@Autowired
	private TaskInstRepository taskInstRepo;
	
	@Autowired
	private MongoOperations mongo;
	
	@Autowired
	private TaskInstRepository taskInstRepository;
	
	@Autowired
	private TaskTemplateRepository taskTemplateRepo;
	
	@Autowired
	private PcWirelessOrderRepository pcWirelessOrderRepository;
	
	@Autowired
	private AsrMilestoneRepository asrMilestoneRepository;
	
	@Value("${url.uteurl}")
	private String uteurl;
	
	@Async
	@Override
	public Future<TaskInst> createTask(TaskInst taskInst) {
		TaskInst taskInstData  = null ;
		try {
			 taskInstData = taskInstRepo.save(taskInst);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AsyncResult<TaskInst>(taskInstData);
	}
	
	
/*	@Override
	public TaskInst transformTaskInst(TaskInst taskInst){
		TaskRefDetail taskRefDetail = taskRefDetailRepo.findByIstimeoutreqTrueAndTaskname(taskInst.getTaskName());
		if(Optional.ofNullable(taskRefDetail).isPresent()){
			DateTime eventCreationTime = taskInst.getEventCreationtime();
			taskInst.setTaskName(taskRefDetail.getActualTaskName());
			taskInst.setExpectedTimeOFCompletion(eventCreationTime.plusMillis((int) taskRefDetail.getTimeoutinms()));
			taskInst.setTaskCreatedTime(new DateTime());
			long taskInstId = getNextSequence("taskinst");
			taskInst.setTaskid(taskInstId);
		z}			
		return taskInst;
	}*/
	
	@Override
	public void transformTaskInst(TaskInst taskInst) {
		logger.info("Transform Task for task details ["+taskInst.toString()+"]");
		 Query query = new Query();
		 query.addCriteria(Criteria.where("templateType").is(taskInst.getSource()));
		   query.with(new  Sort(new Order(Direction.ASC, "sequence")));   
		   query.fields().include("sequence");
		   
		List<String> taskNameList = mongo.getCollection("TaskTemplate").distinct("taskName"  , query.getQueryObject());
		
		query = new Query();
		 query.addCriteria(Criteria.where("templateType").is(taskInst.getSource()));
		   query.with(new  Sort(new Order(Direction.ASC, "sequence")));   
		   query.fields().include("sequence");
	
		List<TaskInst> taskNamesList = mongo.getCollection("TaskTemplate").distinct("taskName"  , query.getQueryObject());
		logger.info("Test data ["+taskNamesList+"]");
		
		List<TaskInst> taskInstList = new ArrayList<>();
		
		if (Optional.ofNullable(taskNameList).isPresent()) {
			taskNameList.stream().forEach(taskName -> {
			
				logger.info("Create Task Template ["+ taskName+"] ");
				
				TaskInst taskInstData = new TaskInst(getNextSequence("TaskTemplate"),  taskName,  taskInst.getPcORderNumber(), taskInst.getPon(), 
						taskInst.getPonVersion(), taskInst.getIcsc(), new Date(),taskInst.getExpectedTimeOFArrival() , taskInst.getTaskCompletionTime(), 
						taskInst.getEventCreationTime(), taskInst.getUserId(), TaskStatus.NEW.toString(), taskInst.getStatusCode(),taskInst.getStatusMesaage(), taskInst.getUteResponsecode(), 
						taskInst.getUteResponseMsg() , taskInst.getSource() , taskInst.getPreCheck() );
					//	taskInstData.setSequence(sequence);
						taskInstList.add(taskInstData);
			}
			);
		}
		taskInstRepo.save(taskInstList);
		
		/*TaskRefDetail taskRefDetail = taskRefDetailRepo.findByIstimeoutreqTrueAndTaskname(taskInst.getTaskName());
		if (Optional.ofNullable(taskRefDetail).isPresent()) {
			taskInst.setTaskName(taskRefDetail.getActualTaskName());
			taskInst.setExpectedTimeOFCompletion(eventCreationTime.plusMillis((int) taskRefDetail.getTimeoutinms()));
			taskInst.setTaskCreatedTime(new DateTime());
			long taskInstId = getNextSequence("taskinst");
			taskInst.setTaskid(taskInstId);
		}*/
	}
	@Override
	public TaskInst initialTaskUpdate(TaskInst currenttaksInst){
		logger.info("Update Task Inst for Task Details ["+currenttaksInst.toString()+"]");
/*		TaskInst taskInstUpd = taskInstRepo.findByPcORderNumberAndPonAndPonVersionAndTaskName(currenttaksInst.getPcORderNumber(), currenttaksInst.getPon(), currenttaksInst.getPonVersion(), currenttaksInst.getTaskName());
		if(taskInstUpd == null && currenttaksInst.getPon() == null){
			AsrMilestone asrMilestone = asrMilestoneRepository.findByOrderNumberAndOrderVersion(currenttaksInst.getPcORderNumber(), " ");
			if(asrMilestone != null){
				currenttaksInst.setPon(asrMilestone.getPon());
				taskInstUpd = taskInstRepo.findByPcORderNumberAndPonAndPonVersionAndTaskName(currenttaksInst.getPcORderNumber(), currenttaksInst.getPon(), currenttaksInst.getPonVersion(), currenttaksInst.getTaskName());			
			}
			
		}*/
		List<TaskTemplate> taskTemplateList  = taskTemplateRepo.findByTaskNameAndTemplateType(currenttaksInst.getTaskName(), currenttaksInst.getSource());
		
	//	logger.info("taskInstUpd ["+taskInstUpd+"]" );
		logger.info( " taskTemplate ["+taskTemplateList+"]");
		
		if(taskTemplateList != null && taskTemplateList.size()>0 ){
				
			taskTemplateList.stream().forEach(taskTemplate->{
				TaskInst taskInstUpd = taskInstRepo.findByPcORderNumberAndPonAndPonVersionAndTaskName(currenttaksInst.getPcORderNumber(), currenttaksInst.getPon(), currenttaksInst.getPonVersion(), currenttaksInst.getTaskName());
				logger.info("taskInstUpd ["+taskInstUpd+"]  currenttaksInst.getPon() ["+currenttaksInst.getPon()+"]" );
				if(taskInstUpd == null && currenttaksInst.getPon() != null){
					AsrMilestone asrMilestone = asrMilestoneRepository.findByOrderNumberAndPonAndponVersionAndicsc(currenttaksInst.getPcORderNumber(), currenttaksInst.getPon(), currenttaksInst.getPonVersion(), currenttaksInst.getIcsc());
					logger.info("asrMilestone ["+asrMilestone+"]" );
					if(asrMilestone != null){
						
						currenttaksInst.setPon(asrMilestone.getPon());
						taskInstUpd = taskInstRepo.findByPcORderNumberAndPonAndPonVersionAndTaskName(currenttaksInst.getPcORderNumber(), currenttaksInst.getPon(), currenttaksInst.getPonVersion(), currenttaksInst.getTaskName());			
						logger.info("taskInstUpd ["+taskInstUpd+"] " );
					}
					
				}
				if(taskInstUpd != null){
				DateTime dateTime = new DateTime(currenttaksInst.getEventCreationTime());		
				logger.info("Status Enum ["+TaskStatus.valueOf("COMPLETE").toString()+"] ");
				Map<String, String> preCheckMap = new HashMap<>();
				if (currenttaksInst.getEventCreationTime() != null && "Y".equals(taskTemplate.getTimeForTask()) && taskTemplate.getNextTask() != null
						&& TaskStatus.valueOf("COMPLETE").toString().equals(currenttaksInst.getTaskStatus())) {
					logger.info("Initiate  the next timer Task And Complete this task ["+currenttaksInst.toString()+"]");
					if (taskTemplate.getToggle() != 0) {
						logger.info("Task having multiple mutually exclusive Next Timer Tasks");
					if(currenttaksInst.getPreCheck() != null && !currenttaksInst.getPreCheck().isEmpty()) {	
						if(taskTemplate.getPreCheck() != null){
							preCheckMap = Splitter.on(",").withKeyValueSeparator("=").split(taskTemplate.getPreCheck());
						}
				
						logger.info("Current Task Precheck Conditions [ "+currenttaksInst.getPreCheck() +" ]  and Task Template Pre Check Conditions [ "+ taskTemplate.getPreCheck()+" ] ");
						
						if(preCheckMap != null && preCheckMap.size() >0){
						preCheckMap.forEach((id, val) -> {
							logger.info("Current Task Precheck Key [ "+id +" ]  and value  [ "+ currenttaksInst.getPreCheck().get(id)+" ]  value ["+val+"]");
								if (currenttaksInst.getPreCheck().containsKey(id) && currenttaksInst.getPreCheck().get(id).equals(val)) {
									List<TaskTemplate> taskTemplateForNextTaskLists = taskTemplateRepo.findByTaskNameAndTemplateType(taskTemplate.getNextTask(),currenttaksInst.getSource() );
									logger.info("Template for next Task [ " + taskTemplateForNextTaskLists.toString() + " ] ");
									taskTemplateForNextTaskLists.stream().forEach(taskTemplateForNextTask -> {
										TaskInst nextTaskUpd = taskInstRepo.findByPcORderNumberAndPonAndPonVersionAndTaskName(
												currenttaksInst.getPcORderNumber(), currenttaksInst.getPon(), currenttaksInst.getPonVersion(),
												taskTemplateForNextTask.getTaskName());
										logger.info("Task Inst Details for Next Task [" + nextTaskUpd.toString() + "]");
										nextTaskUpd.setExpectedTimeOFArrival(
												dateTime.plusMillis((int) taskTemplateForNextTask.getExpectedTimeOutForNextTask()).toDate());
										nextTaskUpd.setTaskStatus(TaskStatus.valueOf("READY").toString());
										taskInstRepo.save(nextTaskUpd);

									});
								}
							});
						}else{
							logger.info("Current Task Precheck value is null HENCE IGNORE THE TASKS ");
							List<TaskTemplate> taskTemplateForNextTaskLists = taskTemplateRepo.findByTaskNameAndTemplateType(taskTemplate.getNextTask(),currenttaksInst.getSource() );
							taskTemplateForNextTaskLists.stream().forEach(taskTemplateForNextTask -> {
								TaskInst nextTaskUpd = taskInstRepo.findByPcORderNumberAndPonAndPonVersionAndTaskName(
										currenttaksInst.getPcORderNumber(), currenttaksInst.getPon(), currenttaksInst.getPonVersion(),
										taskTemplateForNextTask.getTaskName());
								logger.info("Task Inst Details for Next Task [" + nextTaskUpd.toString() + "]");
								nextTaskUpd.setTaskStatus(TaskStatus.valueOf("IGNORE").toString());
								nextTaskUpd.setTaskCompletionTime(new Date());
								taskInstRepo.save(nextTaskUpd);
							});
						}
						}else{
							logger.info("Current Task Without Prechcek Conditions - Hence Execute All the next tasks");
							if(taskTemplate.getPreCheck() == null || taskTemplate.getPreCheck().isEmpty()){
							List<TaskTemplate> taskTemplateForNextTaskList = taskTemplateRepo.findByTaskNameAndTemplateType(taskTemplate.getNextTask(),currenttaksInst.getSource());
							logger.info("Template for next Task [" + taskTemplateForNextTaskList.toString() + "] ");
							taskTemplateForNextTaskList.stream().forEach(taskTemplateForNextTask -> {

								TaskInst nextTaskUpd = taskInstRepo.findByPcORderNumberAndPonAndPonVersionAndTaskName(currenttaksInst.getPcORderNumber(),currenttaksInst.getPon(), currenttaksInst.getPonVersion(), taskTemplateForNextTask.getTaskName());
								logger.info("Task Inst Details for Next Task [" + nextTaskUpd.toString() + "]");
								nextTaskUpd.setExpectedTimeOFArrival(dateTime.plusMillis((int) taskTemplateForNextTask.getExpectedTimeOutForNextTask()).toDate());
								if(!TaskStatus.valueOf("COMPLETE").toString().equals(nextTaskUpd.getTaskStatus())){
									nextTaskUpd.setTaskStatus(TaskStatus.valueOf("READY").toString());
								}
								taskInstRepo.save(nextTaskUpd);

							});
							}
						}
					}else {
							logger.info("Task having only one  Next Timer Tasks");
							List<TaskTemplate> taskTemplateForNextTaskList = taskTemplateRepo.findByTaskNameAndTemplateType(taskTemplate.getNextTask(),currenttaksInst.getSource());

							logger.info("Template for next Task [" + taskTemplateForNextTaskList.toString() + "] ");
							taskTemplateForNextTaskList.stream().forEach(taskTemplateForNextTask -> {

								TaskInst nextTaskUpd = taskInstRepo.findByPcORderNumberAndPonAndPonVersionAndTaskName(currenttaksInst.getPcORderNumber(),currenttaksInst.getPon(), currenttaksInst.getPonVersion(), taskTemplateForNextTask.getTaskName());
								logger.info("Task Inst Details for Next Task [" + nextTaskUpd.toString() + "]");
								nextTaskUpd.setExpectedTimeOFArrival(dateTime.plusMillis((int) taskTemplateForNextTask.getExpectedTimeOutForNextTask()).toDate());
								nextTaskUpd.setTaskStatus(TaskStatus.valueOf("READY").toString());
								taskInstRepo.save(nextTaskUpd);

							});
						}
					}
				if(currenttaksInst.getTaskCreatedTime() == null ){
					 currenttaksInst.setTaskCreatedTime(taskInstUpd.getTaskCreatedTime());
				}
				    currenttaksInst.setTaskid(taskInstUpd.getTaskid());
				    currenttaksInst.setTaskName(taskInstUpd.getTaskName());
			
				logger.info("Update Task Inst with Tasks ["+currenttaksInst.toString()+"]  ");
				taskInstRepo.save(currenttaksInst);
			}
			});
		}
		return currenttaksInst;
	}
	
	@Async
	@Override
	public Future<List<TaskInst>>getTaskList(String pcOrderNumber){
	List<TaskInst> taskInstList  = taskInstRepo.findByPcORderNumber(pcOrderNumber);
	logger.info("taskInstList ["+taskInstList+"]");
		return new AsyncResult<List<TaskInst>>(taskInstList);
	}
	
	
	
	public long getNextSequence(String collectionName) {
		Counters counter = mongo.findAndModify(query(where("id").is(collectionName)), new Update().inc("seq", 1), options().returnNew(true),
				Counters.class);
		return counter.getSeq();
	}


	@Override
	public TaskInst createUTETask(TaskInst taskInst) {
			TaskRequest taskRequest = new TaskRequest();

			
			PcWirelessOrder pcWirelessOrder = pcWirelessOrderRepository.findByOrderOrderNumberAndOrderOrderVersion(taskInst.getPcORderNumber(), " ");

			Optional.ofNullable(pcWirelessOrder).orElseThrow(() -> new DataNotFoundException(null, null,
					"No PC Wireless Order Data found  "));

			AsrMilestone asrMilestoneData = asrMilestoneRepository.findByOrderNumberAndPonAndponVersionAndicsc(taskInst.getPcORderNumber(), taskInst.getPon(), taskInst.getPonVersion(), taskInst.getIcsc());
			
			taskRequest.setTaskSource("VZWTSR");
			taskRequest.setUserId(pcWirelessOrder.getOrderDetails().getUserId());
			taskRequest.setCreator("VZWTSR");
			taskRequest.setDueDate(null);
			taskRequest.setErrorCode("5001");
			taskRequest.setErrorDescription("TASK_TIMEOUT::"+taskInst.getTaskName());
			taskRequest.setTitle(taskInst.getTaskName());
			taskRequest.setExternalTaskId(String.valueOf(taskInst.getTaskid()));
			taskRequest.setCreatedDate(new Date());
			taskRequest.setUpdatedDate(new Date());
			taskRequest.setWorkGroup("WIRELESS_PROVISIONING");
			taskRequest.setWorkPool(pcWirelessOrder.getOrderDetails().getRegion());
			Map<String, String> taskAttributes = new HashMap<>();
			taskAttributes.put("PON", taskInst.getPon());
			taskAttributes.put("PON_VERSION", taskInst.getPonVersion());
			taskAttributes.put("ICSC", taskInst.getIcsc());

			taskRequest.setTaskAttributes(taskAttributes);

			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setServiceOrderNumber(taskInst.getPon());
			orderInfo.setWorkOrderNumber(asrMilestoneData.getOrderNumber());
			orderInfo.setOrderVersion(taskInst.getPonVersion());
			orderInfo.setOrderType(pcWirelessOrder.getOrderDetails().getOrderType());
			orderInfo.setProduct(pcWirelessOrder.getOrderDetails().getProductCategory());
			orderInfo.setSubProduct(pcWirelessOrder.getOrderDetails().getProductSubCategory());
			orderInfo.setOrderSource("VZW");
			orderInfo.setLineOfBusiness("VZW");
			orderInfo.setCircuitID(asrMilestoneData.getCircuitId());
			orderInfo.setCDDD(pcWirelessOrder.getOrderDetails().getCustomerDesiredDueDate());

			taskRequest.setOrderInfo(orderInfo);

			RestTemplate restTemplate = new RestTemplate();
			logger.info("Invokes Task Creation in UTE Milestone Events with url [" + uteurl + "]");
			TaskResponse response = null;// restTemplate.postForObject(uteurl,
											// taskRequest, TaskResponse.class);
			if (response != null) {
				taskInst.setUteResponsecode(response.getFaultCode());
				taskInst.setUteResponseMsg(response.getFaultDescription());
				taskInst.setTaskStatus(response.getTaskStatus());
				taskInst.setTaskid(Long.parseLong(response.getExternalTaskId()));
				taskInst = taskInstRepository.save(taskInst);
			}
			asrMilestoneData.setUteTaskId(Long.parseLong(response.getUteTaskId()));
			asrMilestoneRepository.save(asrMilestoneData);

			return taskInst;
		}
	}


