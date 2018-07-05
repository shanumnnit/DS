package my.gfg.tree.morris.inorder.traversal;

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

	public void inorderMorrisTraversal() {
		if (root == null)
			return;
		Node current = root;
		Node predecessor = null;
		System.out.print("Inorder morris traversal : ");
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				predecessor = findPredessor(current);
				// we have already visited the left subtree of current
				if (predecessor.right == current) {
					System.out.print(current.data + " ");
					predecessor.right = null;
					current = current.right;
				} else {
					predecessor.right = current;
					current = current.left;
				}
			}
		}

	}

	private Node findPredessor(Node current) {
		Node predecessor = current.left;
		while (predecessor.right != null && predecessor.right != current)
			predecessor = predecessor.right;
		return predecessor;
	}

	public void inorderRecursive(Node node) {
		if (node != null) {
			inorderRecursive(node.left);
			System.out.print(node.data + " ");
			inorderRecursive(node.right);
		}
	}

}
