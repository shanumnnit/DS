package my.gfg.heap.find.median.running.stream.numbers;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int t = Integer.parseInt(scn.nextLine());
		while (t-- > 0) {
			int k = scn.nextInt();
			int n = scn.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = scn.nextInt();
			printKthmMaximumNumber(arr, k);
			System.out.println();
		}

		scn.close();
	}

	private static void printKthmMaximumNumber(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(k);
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
			if (i < k - 1)
				System.out.print("-1 ");
			else
				System.out.print(pq.peek() + " ");
		}
		for (int i = k; i < arr.length; i++) {
			if (pq.peek() < arr[i]) {
				pq.poll();
				pq.add(arr[i]);
			}
			System.out.print(pq.peek() + " ");
		}
	}

}
