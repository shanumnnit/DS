package com.ctci.bitwise.next.biggest.smallest.same.no.of.ones;

public class BitwiseTesting {

	public static void main(String[] args) {
		int num = 22;
		System.out.println(Integer.toBinaryString(num));
		int nextLargest = getNextLargestWithSameNoOf1s(num);
		System.out.println(nextLargest);
		System.out.println(Integer.toBinaryString(nextLargest));

	}

	private static int getNextLargestWithSameNoOf1s(int num) {
		int temp = num;
		int c0 = 0, c1 = 0, p = 0;
		while (temp != 0) {
			if ((temp & 1) == 1)
				c1++;
			else if (c1 > 0 && (temp & 1) == 0)
				break;
			else if ((temp & 1) == 0)
				c0++;
			temp >>= 1;
			p++;
		}

		temp = num;
		temp |= (1 << p);
		temp &= (~0 << p);

		temp |= ((1 << (c1 - 1)) - 1);
		
		return temp;
	}
}
