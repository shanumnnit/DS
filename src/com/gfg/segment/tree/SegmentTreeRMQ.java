package com.gfg.segment.tree;

public class SegmentTreeRMQ {
	public int[] createSegmentTree(int[] input) {
		int nextPowerOf2 = (int) Math.ceil(Math.log(input.length) / Math.log(2));

		int segTreeSize = (int) (2 * Math.pow(2, nextPowerOf2) - 1);

		System.out.println("Segment tree size is " + segTreeSize);

		int segTree[] = new int[segTreeSize];
		createSegmentTreeUtil(input, 0, input.length - 1, segTree, 0);

		return segTree;

	}

	private void createSegmentTreeUtil(int[] input, int low, int high, int[] segTree, int pos) {
		if (low == high) {
			segTree[pos] = input[low];
			return;
		}
		int mid = (low + high) / 2;
		createSegmentTreeUtil(input, low, mid, segTree, 2 * pos + 1);
		createSegmentTreeUtil(input, mid + 1, high, segTree, 2 * pos + 2);
		segTree[pos] = Math.min(segTree[2 * pos + 1], segTree[2 * pos + 2]);
	}

	public void getMinimun(int[] segTree, int qLow, int qHigh) {
	}
}
