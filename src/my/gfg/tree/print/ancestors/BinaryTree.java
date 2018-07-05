package my.gfg.tree.print.ancestors;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

	public boolean printAncestors(Node node, int data) {
		if (node == null)
			return false;
		if (node.data == data)
			return true;
		if (printAncestors(node.left, data) || printAncestors(node.right, data)) {
			System.out.print(node.data + " ");
			return true;
		}
		return false;
	}
}