package my.gfg.arrays.find.equilibrium;

import java.util.Scanner;

public class ArrayEquilibrium {

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

			int cumAsc[] = new int[n];
			int cumDesc[] = new int[n];

			cumAsc[0] = arr[0];
			for (int i = 1; i < n; i++)
				cumAsc[i] = cumAsc[i - 1] + arr[i];

			cumDesc[n - 1] = arr[n - 1];
			for (int i = n - 2; i >= 0; i--)
				cumDesc[i] = cumDesc[i + 1] + arr[i];

			int eqIndex = -2;
			for (int i = 0; i < n; i++)
				if (cumAsc[i] == cumDesc[i]) {
					eqIndex = i;
					break;
				}
			System.out.println(eqIndex + 1);

		}
	}

}
