package my.gfg.tree.connect.node.same.level;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	int data;
	Node left, right, next_right;

	public Node(int data) {
		super();
		this.data = data;
	}

}

public class BinaryTree {
	Node root;

	public void connectNodesAtSameLevel() {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		Node nextRight;

		int countAtSameLevel;
		while (!queue.isEmpty()) {
			countAtSameLevel = queue.size();
			while (countAtSameLevel-- > 0) {
				Node current = queue.remove();
				if (!queue.isEmpty() && countAtSameLevel > 0)
					nextRight = queue.peek();
				else
					nextRight = null;
				current.next_right = nextRight;
				if (current.left != null)
					queue.add(current.left);
				if (current.right != null)
					queue.add(current.right);
			}
		}
	}

	public void printRight(Node node) {
		if (node == null)
			return;
		System.out.print("Print right is:");
		while (node != null) {
			System.out.print(" " + node.data);
			node = node.next_right;
		}
		System.out.println();
	}
}
