package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.expense.master.ExpenseServiceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ExpenseServiceApplication.class)
public class ExpenseServiceApplicationTests {

	@Test
	public void contextLoads() {
		
		System.out.println(" hello ");
	}

}
