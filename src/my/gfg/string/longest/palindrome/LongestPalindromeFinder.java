package my.gfg.string.longest.palindrome;

import java.util.Arrays;
import java.util.Scanner;

public class LongestPalindromeFinder {

	public static void main(String[] args) {
		int t = 0;
		Scanner scn = new Scanner(System.in);

		while (t-- > 0) {
			String strToCheck = scn.nextLine();
			printLongestPalindrome(strToCheck);
			System.out.println();
		}
	}

	private static void printLongestPalindrome(String strToCheck) {
		int n = strToCheck.length();
		boolean dpArr[][] = new boolean[n][n];
		for (boolean[] b : dpArr)
			Arrays.fill(b, false);

		int palindromeLength = 0;
		String palindromeString = "";

		// for length 1
		for (int i = 0; i < n; i++) {
			dpArr[i][i] = true;
			if (palindromeLength < 1) {
				palindromeLength = 1;
				palindromeString = String.valueOf(strToCheck.charAt(i));
			}
		}

		// for length 2
		for (int i = 0; i < n - 1; i++)
			if (strToCheck.charAt(i) == strToCheck.charAt(i + 1)) {
				dpArr[i][i + 1] = true;
				if (palindromeLength < 2) {
					palindromeLength = 2;
					palindromeString = strToCheck.substring(i, i + 2);
				}
			}

		for (int k = 2; k < strToCheck.length(); k++) {
			for (int i = 0; (i + k) < strToCheck.length(); i++) {
				if (strToCheck.charAt(i) == strToCheck.charAt(i + k) && dpArr[i + 1][i + k - 1] == true) {
					dpArr[i][i + k] = true;
					if (palindromeLength < (k + 1)) {
						palindromeLength = k + 1;
						palindromeString = strToCheck.substring(i, i + k + 1);
					}
				}
			}
		}

		System.out.println(palindromeString);
	}

}
