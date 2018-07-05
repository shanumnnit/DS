package my.gfg.stack.sort.using.recursion;

import java.util.Stack;

public class Tester {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(30);
		stack.push(-5);
		stack.push(18);
		stack.push(14);
		stack.push(-3);

		System.out.println(stack);

		sortStack(stack);

		System.out.println(stack);

	}

	private static void sortStack(Stack<Integer> stack) {
		if (stack.isEmpty())
			return;
		int top = stack.pop();
		sortStack(stack);
		sortedInsert(stack, top);
	}

	private static void sortedInsert(Stack<Integer> stack, int ele) {
		if (stack.isEmpty() || stack.peek() <= ele) {
			stack.push(ele);
			return;
		}
		int currTop = stack.pop();
		sortedInsert(stack, ele);
		stack.push(currTop);

	}

}
