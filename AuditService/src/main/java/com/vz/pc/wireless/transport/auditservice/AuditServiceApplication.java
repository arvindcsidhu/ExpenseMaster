package com.vz.pc.wireless.transport.auditservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author PEACJA7
 *
 */
@SpringBootApplication
public class AuditServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(AuditServiceApplication.class);

	public static void main(String[] args) {

		logger.info("---------------Start Microservice - OrderCollectionServiceApplication----------");
		SpringApplication.run(AuditServiceApplication.class, args);
	}

}
