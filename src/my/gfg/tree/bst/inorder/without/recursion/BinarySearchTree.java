package my.gfg.tree.bst.inorder.without.recursion;

import java.util.Stack;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
	}
}

public class BinarySearchTree {
	Node root;

	public void insert(int data) {
		root = insertRec(root, data);
	}

	public Node insertRec(Node node, int data) {
		if (node == null) {
			return new Node(data);
		}
		if (node.data > data)
			node.left = insertRec(node.left, data);
		else
			node.right = insertRec(node.right, data);
		return node;
	}

	public void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(" " + node.data);
		inorder(node.right);
	}

	//to correct
	public void inorderWithoutRecursion() {
		if (root == null)
			return;
		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node node = stack.peek();
			while (node.left != null) {
				stack.push(node);
				node = node.left;
			}

			node = stack.pop();
			System.out.print(" " + node.data);

			if (node.right != null)
				stack.push(node.right);

		}
	}
}
