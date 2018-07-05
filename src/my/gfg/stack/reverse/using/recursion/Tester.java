package my.gfg.stack.reverse.using.recursion;

import java.util.Stack;

public class Tester {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		System.out.println(stack);

		reverse(stack);

		System.out.println(stack);

	}

	private static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty())
			return;
		int top = stack.pop();
		reverse(stack);
		insertAtBottom(stack, top);
	}

	private static void insertAtBottom(Stack<Integer> stack, int top) {
		if (stack.isEmpty()) {
			stack.push(top);
			return;
		}
		int currTop = stack.pop();
		insertAtBottom(stack, top);
		stack.push(currTop);

	}

}
