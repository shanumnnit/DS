package my.gfg.tree.diameter;

class Height {
	int h;
}

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

	public int getDiameter(Node node) {
		if (node == null) {
			return 0;
		}
		int diamterTakingNode = height(node.left) + height(node.right) + 1;
		int dimaterNotTakingNode = Math.max(getDiameter(node.left), getDiameter(node.right));
		return Math.max(diamterTakingNode, dimaterNotTakingNode);
	}

	public int getDiameteroptimized(Node node, Height height) {
		if (node == null) {
			height.h = 0;
			return 0;
		}
		Height lh = new Height(), rh = new Height();
		lh.h++;
		rh.h++;
		int dimaterNotTakingNode = Math.max(getDiameteroptimized(node.left, lh), getDiameteroptimized(node.right, rh));
		int diamterTakingNode = lh.h + rh.h + 1;
		height.h = Math.max(lh.h, rh.h) + 1;
		return Math.max(diamterTakingNode, dimaterNotTakingNode);
	}
}