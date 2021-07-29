package com.springboot.datastructures.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.datastructures.Queue;

@SpringBootTest(classes = { Queue.class })
@RunWith(SpringRunner.class)
public class QueueTest {

	private static final Logger logger = LogManager.getLogger(QueueTest.class);

	@Test
	public void enqueueDequeueTest() {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);

		Integer val = null;
		do {
			val = queue.dequeue();
			logger.info(val);
		} while (val != null);
	}

}
