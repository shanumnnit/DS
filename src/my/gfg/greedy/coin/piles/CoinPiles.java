package my.gfg.greedy.coin.piles;

import java.util.Arrays;
import java.util.Scanner;

public class CoinPiles {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = Integer.parseInt(scn.nextLine());
		while (t-- > 0) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			System.out.println(getMinimumCoinChages(arr, n, k));
		}
	}

	private static int getMinimumCoinChages(int[] arr, int n, int k) {
		int minChanges = 0;
		Arrays.sort(arr);
		for (int i = 0, j = n - 1; i < j; i++, j--) {
			if ((arr[j] - arr[i]) > k) {
				minChanges += (arr[j] - arr[i] -k);
			}
		}
		return minChanges;
	}

}
