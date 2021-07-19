package com.springboot.algorithms.test;

import java.util.Arrays;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
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
		int[] initial = new Random().ints(10, -100, 100).toArray();
		logger.info("Initial: {}", Arrays.toString(initial));

		int[] arr = Arrays.copyOf(initial, initial.length);
		arr = this.quickSort.sort(arr, 0, arr.length - 1);
		logger.info("Sorted:  {}", Arrays.toString(arr));

		int[] javaSorted = Arrays.copyOf(initial, initial.length);
		Arrays.sort(javaSorted);

		Assert.assertArrayEquals(javaSorted, arr);
	}

}
