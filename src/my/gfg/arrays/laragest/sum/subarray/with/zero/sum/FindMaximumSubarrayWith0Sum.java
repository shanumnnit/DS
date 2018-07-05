package my.gfg.arrays.laragest.sum.subarray.with.zero.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindMaximumSubarrayWith0Sum {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = Integer.parseInt(scn.nextLine());
		while (t-- > 0) {
			int n = scn.nextInt();
			;
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}

			System.out.println(findMaximumSumSubarrayWithZeroSum(arr, n));

		}
	}

	private static int findMaximumSumSubarrayWithZeroSum(int[] arr, int n) {
		int result = 0;
		int cumArr[] = new int[n];
		HashMap<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (i == 0)
				cumArr[i] = arr[i];
			else
				cumArr[i] = cumArr[i - 1] + arr[i];
			if (map.containsKey(cumArr[i]))
				map.get(cumArr[i]).add(i);
			else
				map.put(cumArr[i], new ArrayList<>(Arrays.asList(i)));
		}
		if (cumArr[n - 1] == 0)
			return n;
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() > 1) {
				if (result < (entry.getValue().get(entry.getValue().size() - 1) - entry.getValue().get(0)))
					result = entry.getValue().get(entry.getValue().size() - 1) - entry.getValue().get(0);
			}
		}

		return result;
	}

}
