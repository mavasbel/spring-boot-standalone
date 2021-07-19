package com.springboot.algorithms;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class QuickSort {

	private static Logger logger = LogManager.getLogger(QuickSort.class);

	public int[] sort(int[] arr, int idx0, int idx1) {
		if (idx0 < idx1) {
			int prevPivotIdx = this.partitionLast(arr, idx0, idx1);
			logger.debug("{}", Arrays.toString(arr));
			this.sort(arr, idx0, prevPivotIdx - 1);
			this.sort(arr, prevPivotIdx + 1, idx1);
		}
		return arr;
	}

	private int partitionLast(int[] arr, int idx0, int idx1) {
		int pivot = arr[idx1];
		int i0 = idx0;
		for (int i1 = idx0; i1 <= idx1; i1++)
			if (arr[i1] < pivot)
				this.swap(arr, i0++, i1);
		this.swap(arr, i0, idx1);
		return i0;
	}

	@SuppressWarnings("unused")
	private int partitionFirst(int[] arr, int idx0, int idx1) {
		int pivot = arr[idx0];
		int j0 = idx1;
		for (int j1 = idx1; j1 >= idx0; j1--)
			if (pivot < arr[j1])
				this.swap(arr, j1, j0--);
		this.swap(arr, idx0, j0);
		return j0;
	}

	private void swap(int[] arr, int idx0, int idx1) {
		int temp = arr[idx0];
		arr[idx0] = arr[idx1];
		arr[idx1] = temp;
	}

}
