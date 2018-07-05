package my.gfg.string.reverse.words;

import java.util.Scanner;

public class ReverseWordsInString {

	public static void main(String[] args) {
		int t = 0;
		Scanner scn = new Scanner(System.in);
		t = Integer.valueOf(scn.nextLine());

		while (t-- > 0) {
			String strToCheck = scn.nextLine();
			String[] strArr = strToCheck.split("\\.");
			String temp = "";
			for (int i = 0, j = strArr.length - 1; i < j; i++, j--) {
				temp = strArr[i];
				strArr[i] = strArr[j];
				strArr[j] = temp;
			}
			System.out.println(String.join(".", strArr));
		}
	}

}
