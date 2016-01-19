package com.vz.pc.wireless.transport.auditservice.model.mongod.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.vz.pc.wireless.transport.auditservice.model.mongod.collection.TaskTemplate;

public interface TaskTemplateRepository extends MongoRepository<TaskTemplate, Long>{

	@Query("{'taskName' : ?0, templateType :?1}")
	public List<TaskTemplate>  findByTaskNameAndTemplateType(String takeName , String templateType);
	
	@Query("{'taskName' : ?0, templateType :?1}")
	public List<TaskTemplate>  findByTaskNameAndTemplateTypeAndPreCheckIsNull(String takeName , String templateType);
}
