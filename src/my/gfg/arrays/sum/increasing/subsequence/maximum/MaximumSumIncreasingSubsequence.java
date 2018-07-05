package my.gfg.arrays.sum.increasing.subsequence.maximum;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumIncreasingSubsequence {

	static int[] memoized;

	public static void main(String[] args) {
		int t;
		Scanner scn = new Scanner(System.in);
		t = scn.nextInt();

		while (t-- > 0) {
			int n = 0;
			n = scn.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = scn.nextInt();

			memoized = new int[n + 1];

			Arrays.fill(memoized, Integer.MIN_VALUE);
			System.out.println(maxSumIncreasingSubsequence(arr, 0, 0));
		}
	}

	private static int maxSumIncreasingSubsequence(int[] arr, int stIndex, int maxSoFar) {
		if (memoized[stIndex] != Integer.MIN_VALUE) {
			System.out.println("Returning " + memoized[stIndex] + " for " + stIndex);
			return memoized[stIndex];
		}
		if (stIndex >= arr.length) {
			return 0;
		}
		if (arr[stIndex] < maxSoFar) {
			memoized[stIndex] = Math.max(arr[stIndex], maxSumIncreasingSubsequence(arr, stIndex + 1, maxSoFar));
			System.out.println("Saving " + memoized[stIndex] + " for " + stIndex);
			return memoized[stIndex];
		} else {
			memoized[stIndex] = Math.max(arr[stIndex] + maxSumIncreasingSubsequence(arr, stIndex + 1, arr[stIndex]),
					maxSumIncreasingSubsequence(arr, stIndex + 1, maxSoFar));
			System.out.println("Saving " + memoized[stIndex] + " for " + stIndex);
			return memoized[stIndex];
		}
	}

}
