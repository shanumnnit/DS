package com.ctci.strings.permutation.is.palindrom;

import java.util.Scanner;

public class PermutationIsPalindrome {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int[] chArr = new int[26];
		int evenCount = 0, oddCount = 0;
		for (int i = 0; i < str.length(); i++) {
			chArr[str.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (chArr[i] == 0)
				continue;
			if (chArr[i] % 2 == 0)
				evenCount++;
			else
				oddCount++;
		}
		String result = "NO";
		if (str.length() % 2 == 1 && oddCount == 1) {
			result = "YES";
		} else if (str.length() % 2 == 0 && oddCount == 0) {
			result = "YES";
		}
		System.out.println(result);
	}

}
