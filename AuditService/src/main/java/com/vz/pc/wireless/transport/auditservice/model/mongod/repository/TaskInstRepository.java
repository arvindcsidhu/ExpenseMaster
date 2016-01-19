package com.vz.pc.wireless.transport.auditservice.model.mongod.repository;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.vz.pc.wireless.transport.auditservice.model.mongod.collection.TaskInst;

@Configuration
public interface TaskInstRepository extends MongoRepository<TaskInst, Long> {
	@Query("{'pcORderNumber' : ?0}}")
	public List<TaskInst> findByPcORderNumber(String pcOrderNumber);
	
	
	@Query("{'pcORderNumber' : ?0, pon :?1, ponVersion :?2 , taskName : ?3}}")
	public TaskInst findByPcORderNumberAndPonAndPonVersionAndTaskName(String pcOrderNumber , String pon , String ponVersion , String taskName );
	
	
}
