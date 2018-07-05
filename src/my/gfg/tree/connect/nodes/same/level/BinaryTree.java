package my.gfg.tree.connect.nodes.same.level;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	int data;
	Node left, right, nextRight;

	public Node(int data) {
		super();
		this.data = data;
		this.left = this.right = null;
	}

}

class BinaryTree {
	Node root;

	public void connect(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		Node dummyNode = new Node(Integer.MIN_VALUE);
		queue.add(root);
		queue.add(dummyNode);

		Node curr = root, prev = null;

		while (!queue.isEmpty()) {
			while (queue.peek().data != Integer.MIN_VALUE) {
				curr = queue.poll();
				if (prev != null)
					prev.nextRight = curr;
				if (curr.left != null)
					queue.add(curr.left);
				if (curr.right != null)
					queue.add(curr.right);
				prev = curr;
			}
			curr.nextRight = null;
			queue.poll();
			if (!queue.isEmpty())
				queue.add(dummyNode);
			prev = null;
		}

	}

	public void printNextRight(Node node) {
		Node temp = node;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.nextRight;
		}
	}
}