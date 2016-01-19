package com.vz.pc.wireless.transport.auditservice.service;

import java.util.List;
import java.util.concurrent.Future;

import com.vz.pc.wireless.transport.auditservice.model.mongod.collection.TaskInst;

public interface TaskCreationService {
	
	public Future<TaskInst> createTask(TaskInst taskInst);

	public void transformTaskInst(TaskInst taskInst);
	
	public Future<List<TaskInst>> getTaskList(String pcOrderNumber);

	public TaskInst initialTaskUpdate(TaskInst taskInst);
	
	
	public TaskInst createUTETask(TaskInst taskInst);
}
