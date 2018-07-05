package my.gfg.string.parenthesis.checker;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class ParenthesisChecker {

	public static void main(String[] args) {
		int t = 0;
		Scanner scn = new Scanner(System.in);
		t = Integer.valueOf(scn.nextLine());

		while (t-- > 0) {
			String strToCheck = scn.nextLine();

			if (strToCheck.charAt(0) == '}' || strToCheck.charAt(0) == ')' || strToCheck.charAt(0) == ']') {
				System.out.println("not balanced");
				continue;
			}

			Stack<Character> stack = new Stack<>();
			stack.push(strToCheck.charAt(0));
			try {
				boolean isBalanced = true;
				outer: for (int i = 1; i < strToCheck.length(); i++) {
					switch (strToCheck.charAt(i)) {
					case '(':
					case '{':
					case '[':
						stack.push(strToCheck.charAt(i));
						break;
					case ')':
						if (stack.peek() != '(') {
							isBalanced = false;
							break outer;
						}
						stack.pop();
						break;
					case '}':
						if (stack.peek() != '{') {
							isBalanced = false;
							break outer;
						}
						stack.pop();
						break;
					case ']':
						if (stack.peek() != '[') {
							isBalanced = false;
							break outer;
						}
						stack.pop();
						break;
					default:
						isBalanced = false;
					}
				}

				if (!stack.isEmpty() || !isBalanced)
					System.out.println("not balanced");
				else
					System.out.println("balanced");
			} catch (EmptyStackException e) {
				System.out.println("not balanced");
			}

		}
	}

}
