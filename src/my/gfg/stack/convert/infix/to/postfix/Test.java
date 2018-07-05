package my.gfg.stack.convert.infix.to.postfix;

import java.util.Stack;

public class Test {

	public static void main(String[] args) {
//		StringBuffer infix = new StringBuffer("a+b*(c^d-e)^(f+g*h)-i");
		StringBuffer infix = new StringBuffer("");
		System.out.println("Infix: " + infix);
		StringBuffer postfix = convertInfixToPostFix(infix);
		System.out.println("Postfix: " + postfix);

	}

	private static StringBuffer convertInfixToPostFix(StringBuffer infix) {
		Stack<Character> stack = new Stack<>();
		StringBuffer postfix = new StringBuffer("");
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				postfix.append(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					char operatorFromStack = stack.pop();
					postfix.append(operatorFromStack);
				}
				if (!stack.isEmpty() && stack.peek() == '(')
					stack.pop();
			} else {
				while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek()))
					postfix.append(stack.pop());
				stack.push(c);
			}

		}
		while (!stack.isEmpty()) {
			char operatorFromStack = stack.pop();
			postfix.append(operatorFromStack);
		}
		return postfix;
	}

	private static int precedence(Character operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		}
	}

}
