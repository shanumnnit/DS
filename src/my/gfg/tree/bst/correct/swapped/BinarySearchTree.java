package my.gfg.tree.bst.correct.swapped;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
	}
}

public class BinarySearchTree {
	Node root, first, middle, prev, last;

	public void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(" " + node.data);
		inorder(node.right);
	}

	public void correctBSTutil(Node node) {
		if (node == null)
			return;
		correctBSTutil(node.left);
		if (prev != null && node.data < prev.data) {
			if (first == null) {
				first = prev;
				middle = node;
			} else
				last = node;
		}
		prev = node;
		correctBSTutil(node.right);
	}

	public void correctBST() {
		correctBSTutil(this.root);
		if (first != null && last != null) {
			int temp = first.data;
			first.data = last.data;
			last.data = temp;
		} else if (first != null && middle != null) {
			int temp = first.data;
			first.data = middle.data;
			middle.data = temp;
		}
	}
}
