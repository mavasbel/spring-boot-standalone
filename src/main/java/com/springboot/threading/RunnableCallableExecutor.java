package com.springboot.threading;

import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunnableCallableExecutor {

	private final static Logger logger = LogManager.getLogger(RunnableCallableExecutor.class);

	public void ExecuteInExecutor() {
		Runnable run = new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while (i < 10) {
					try {
						Thread.sleep(500);
						System.out.println(String.format("From Runnable run method: (i: %d: Instant: %s)", i,
								Instant.now().toString()));
						i++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Callable<Integer> cal = new Callable<Integer>() {
			@Override
			public Integer call() throws InterruptedException {
				int i = 0;
				while (i < 10) {
					Thread.sleep(1000);
					System.out.println(String.format("From Callable call method: (i: %d: Instant: %s)", i,
							Instant.now().toString()));
					i++;
				}
				return i;
			}
		};

		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
		fixedThreadPool.submit(run);
		Future<Integer> fut = fixedThreadPool.submit(cal);

		while (!fut.isDone())
			;
		try {
			System.out.println(String.format("Callable Future done, final value: %d", fut.get()));
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		fixedThreadPool.shutdown();
	}
}
