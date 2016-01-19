package com.vz.pc.wireless.transport.auditservice.model.mongod.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vz.pc.wireless.transport.auditservice.model.mongod.collection.TaskRefDetail;
/**
 * 
 * @author PEACJA7
 *
 */
public interface TaskRefDetailRepository extends MongoRepository<TaskRefDetail, Long> {

	/**
	 * Do no Change the method name or signature As it aligns with spring data repository & mongo Collection
	 */
	public TaskRefDetail findByIstimeoutreqTrueAndTaskname(String taskname);
	
	

}
