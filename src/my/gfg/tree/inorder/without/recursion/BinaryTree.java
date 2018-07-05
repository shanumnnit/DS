package my.gfg.tree.inorder.without.recursion;

import java.util.Stack;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		super();
		this.data = data;
		this.left = this.right = null;
	}

}

class BinaryTree {
	Node root;

	public int height(Node node) {
		if (node == null)
			return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}

	public void inorderTraversal() {
		if (root == null)
			return;
		Stack<Node> stack = new Stack<>();
		Node current = root;
		while (current != null) {
			stack.push(current);
			current = current.left;
		}

		while (!stack.isEmpty()) {
			current = stack.pop();
			System.out.print(current.data + " ");
			if (current.right != null) {
				current = current.right;
				while (current != null) {
					stack.push(current);
					current = current.left;
				}
			}
		}
	}

}
