package com.ctci.dp.nsteps;

public class NStairsProblem {

	public static void main(String[] args) {
		int n = 10;
		System.out.println(getNumberOfWaysToClimbStairs(n));
		System.out.println(countWaysGFG(n));
	}

	private static int getNumberOfWaysToClimbStairs(int n) {
		int a = 1, b = 2, c = 4, d = 0;

		if (n == 0 || n == 1 || n == 2)
			return n;
		if (n == 3)
			return c;

		for (int i = 0; i < n - 3; i++) {
			d = c + b + a;
			a = b;
			b = c;
			c = d;
		}
		return d;
	}

	private static int countWaysGFG(int n) {
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		res[2] = 2;

		for (int i = 3; i <= n; i++)
			res[i] = res[i - 1] + res[i - 2] + res[i - 3];

		return res[n];
	}
}
