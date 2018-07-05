package my.gfg.string.print.permutations;

import java.util.Scanner;

public class StringPermutations {

	public static void main(String[] args) {
		int t = 0;
		Scanner scn = new Scanner(System.in);
		t = Integer.valueOf(scn.nextLine());

		while (t-- > 0) {
			String strToCheck = scn.nextLine();
			printPermutations(strToCheck, 0, strToCheck.length() - 1);
			System.out.println();
		}
	}

	private static void printPermutations(String strToCheck, int l, int r) {
		if (l >= r) {
			System.out.print(strToCheck + " ");
			return;
		}
		for (int i = l; i <= r; i++) {
			strToCheck = swap(strToCheck, l, i);
			printPermutations(strToCheck, l + 1, r);
			strToCheck = swap(strToCheck, l, i);
		}
	}

	private static String swap(String strToCheck, int i, int j) {
		char temp;
		char[] charArray = strToCheck.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

}
