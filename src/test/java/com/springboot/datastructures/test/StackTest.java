package com.springboot.datastructures.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.datastructures.Stack;

@SpringBootTest(classes = { Stack.class })
@RunWith(SpringRunner.class)
public class StackTest {

	private static final Logger logger = LogManager.getLogger(StackTest.class);

	@Test
	public void addAndRemovingElements() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		Integer val = null;
		do {
			val = stack.pop();
			logger.info(val);
		} while (val != null);
	}

}
