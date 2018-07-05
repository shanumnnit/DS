package my.gfg.string.check.anagrams;

import java.util.Arrays;
import java.util.Scanner;

public class StringAnagram {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = Integer.parseInt(scn.nextLine());

		int[] arr = new int[26];
		while (t-- > 0) {
			String str1 = scn.nextLine();
			String str2 = scn.nextLine();
			if (str1.length() != str2.length()) {
				System.out.println("NO");
				continue;
			}
			Arrays.fill(arr, 0);
			for (int i = 0; i < str1.length(); i++) {
				arr[str1.charAt(i) - 'a']++;
				arr[str2.charAt(i) - 'a']--;
			}
			boolean isAnagram = true;
			for (int i = 0; i < arr.length; i++)
				if (arr[i] != 0)
					isAnagram = false;
			if (isAnagram)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
