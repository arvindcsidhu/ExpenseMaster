package com.vz.pc.wireless.transport.auditservice.model.mongod.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.vz.pc.wireless.transport.auditservice.model.mongod.collection.PcWirelessOrder;

public interface PcWirelessOrderRepository extends MongoRepository<PcWirelessOrder, Long> {

	@Query("{'order.orderNumber' : ?0 , 'order.orderVersion' : ?1}")
	public PcWirelessOrder findByOrderOrderNumberAndOrderOrderVersion(String orderNumber , String orderVersion);
}
