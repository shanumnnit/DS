package my.gfg.tree.bst.crud;

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

	public Node delete(Node node, int data) {
		if (node == null)
			return null;
		if (node.data < data)
			node.right = delete(node.right, data);
		else if (node.data > data)
			node.left = delete(node.left, data);
		else {
			if (node.left == null)
				node = node.right;
			else if (node.right == null)
				node = node.left;
			else {
				node.data = inorderSuccessor(node.right);
				delete(node.right, node.data);
			}
		}
		return node;
	}

	private int inorderSuccessor(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node.data;
	}

	private Node search(Node node, int data) {
		if (node == null)
			return null;
		if (node.data == data)
			return node;
		if (node.data < data)
			return search(node.right, data);
		else
			return search(node.left, data);
	}
}
