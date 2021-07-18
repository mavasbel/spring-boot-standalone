package com.springboot.algorithms.test;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.algorithms.QuickSort;

@SpringBootTest(classes = QuickSort.class)
@RunWith(SpringRunner.class)
public class QuickSortTest {

	private static Logger logger = LogManager.getLogger(QuickSortTest.class);

	@Autowired
	private QuickSort quickSort;

	@Test
	public void sortingTest() {
		int[] arr = { 222, 544, 1232, 1, 54, -7, 1, 3, -5, -125, 43, 44 };
		logger.info("{}", Arrays.toString(arr));
		this.quickSort.sort(arr, 0, arr.length - 1);
		logger.info("{}", Arrays.toString(arr));
	}

}
