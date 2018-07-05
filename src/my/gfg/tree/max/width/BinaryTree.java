package my.gfg.tree.max.width;

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

	public int getMaxWidth() {
		if (root == null)
			return 0;
		int maxWidth = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int count;
		while (!queue.isEmpty()) {
			count = queue.size();
			maxWidth = Math.max(count, maxWidth);
			while (count-- > 0) {
				Node temp = queue.remove();
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
		}
		return maxWidth;
	}
}