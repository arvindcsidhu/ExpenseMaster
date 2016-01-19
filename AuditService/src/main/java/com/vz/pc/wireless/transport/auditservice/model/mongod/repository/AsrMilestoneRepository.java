package com.vz.pc.wireless.transport.auditservice.model.mongod.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.vz.pc.wireless.transport.auditservice.model.mongod.collection.AsrMilestone;
/**
 * 
 * @author PEACJA7
 *
 */
public interface AsrMilestoneRepository extends MongoRepository<AsrMilestone, Long> {

	/**
	 * Do no Change the method name or signature As it aligns with spring data repository & mongo Collection
	 */
	@Query("{'orderNumber' : ?0, pon :?1, ponVersion :?2 , icsc : ?3}}")
	public AsrMilestone findByOrderNumberAndPonAndponVersionAndicsc(String orderNumber ,
			String pon , String ponVersion , String icsc);
	
	@Query("{'orderNumber' : ?0,icsc : ?1}}")
	public AsrMilestone findByOrderNumberAndIcsc(String orderNumber , String icsc);
	

	@Query("{'orderNumber' : ?0,orderVersion : ?1}}")
	public AsrMilestone findByOrderNumberAndOrderVersion(String orderNumber , String orderVersion);
	
	@Query("{'id' : ?0}}")
	public AsrMilestone findById(long transactionId);
}
