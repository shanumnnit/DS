package my.gfg.arrays.laragest.sum.subarray.non.adjacent;

public class Tester {

	public static void main(String[] args) {
		int[] a = {5, 5, 10, 100, 10, 5};
		System.out.println("Maximum contiguous sum is " + maxSubArrayNonAdjacentSum(a));
	}

	private static int maxSubArrayNonAdjacentSum(int[] a) {
		return maxSubArrayNonAdjacentSumUtil(a, 0);
	}

	private static int maxSubArrayNonAdjacentSumUtil(int[] a, int i) {
		if (i >= a.length)
			return 0;
		int sumTakingI = a[i] + maxSubArrayNonAdjacentSumUtil(a, i + 2);
		int sumNotTakingI = maxSubArrayNonAdjacentSumUtil(a, i + 1);

		return Math.max(sumTakingI, sumNotTakingI);
	}

}
