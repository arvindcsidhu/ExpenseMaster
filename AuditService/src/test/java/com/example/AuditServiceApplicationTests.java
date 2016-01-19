package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vz.pc.wireless.transport.auditservice.AuditServiceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AuditServiceApplication.class)
public class AuditServiceApplicationTests {

	@Test
	public void contextLoads() {
		
		System.out.println(" hello ");
	}

}
