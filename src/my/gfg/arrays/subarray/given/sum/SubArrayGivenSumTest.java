package my.gfg.arrays.subarray.given.sum;

import java.util.Scanner;

public class SubArrayGivenSumTest {

	public static void main(String[] args) {
		int t;
		Scanner scn = new Scanner(System.in);
		t = scn.nextInt();

		while (t-- > 0) {
			int n, sum;
			n = scn.nextInt();
			sum = scn.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = scn.nextInt();

			int[] cumulative = new int[n + 1];
			cumulative[0] = 0;
			cumulative[1] = arr[0];
			for (int i = 2; i < n + 1; i++) {
				cumulative[i] = cumulative[i - 1] + arr[i - 1];
			}

			int firstIndex = 0, secondIndex = 0;
			// search for indices
			for (int i = 0; i < n + 1; i++) {
				firstIndex = i;
				secondIndex = binarySearch(cumulative, cumulative[firstIndex] + sum, firstIndex + 1, n);
				if (secondIndex != -1)
					break;
			}
			if (secondIndex != -1)
				System.out.println((firstIndex + 1) + " " + (secondIndex));
			else
				System.out.println("-1");

		}
	}

	private static int binarySearch(int[] cumulative, int toSearch, int l, int h) {
		if (l > h)
			return -1;
		int mid = (l + h) / 2;
		if (cumulative[mid] == toSearch)
			return mid;
		else if (cumulative[mid] > toSearch)
			return binarySearch(cumulative, toSearch, l, mid - 1);
		else
			return binarySearch(cumulative, toSearch, mid + 1, h);
	}

}
