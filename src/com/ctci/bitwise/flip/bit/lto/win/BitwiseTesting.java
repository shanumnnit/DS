package com.ctci.bitwise.flip.bit.lto.win;

public class BitwiseTesting {

	public static void main(String[] args) {
		int num = 6;
		System.out.println(Integer.toBinaryString(num));
		System.out.println(flipOneBit(num));
	}

	private static int flipOneBit(int num) {
		int curLen = 0, prevLen = 0;
		int max = 1;
		while (num != 0) {
			if ((num & 1) == 1)
				curLen++;
			else {
				if ((num & 2) == 2)
					prevLen = curLen;
				else
					prevLen = 0;
				curLen = 0;
			}
			max = Math.max(max, prevLen + curLen + 1);
			num >>= 1;
		}
		return max;
	}

}
