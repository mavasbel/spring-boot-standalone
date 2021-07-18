package com.springboot.algorithms;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class MergeSort {

	public int[] sort(int[] arr) {
		int mid = arr.length / 2;

		int[] arr1 = Arrays.copyOfRange(arr, 0, mid);
		int[] arr2 = Arrays.copyOfRange(arr, mid, arr.length);

		if (arr1.length > 1)
			arr1 = this.sort(arr1);
		if (arr2.length > 1)
			arr2 = this.sort(arr2);

		int[] merged = this.merge(arr1, arr2);

		return merged;
	}

	private int[] merge(int[] arr1, int[] arr2) {
		int i1 = 0, i2 = 0, m = 0;
		int[] merged = new int[arr1.length + arr2.length];
		while (i1 < arr1.length && i2 < arr2.length) {
			if (arr1[i1] < arr2[i2])
				merged[m++] = arr1[i1++];
			else
				merged[m++] = arr2[i2++];
		}
		while (i1 < arr1.length)
			merged[m++] = arr1[i1++];
		while (i2 < arr2.length)
			merged[m++] = arr2[i2++];
		return merged;
	}

}
