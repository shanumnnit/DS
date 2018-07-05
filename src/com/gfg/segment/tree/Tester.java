package com.gfg.segment.tree;

public class Tester {
	public static void main(String[] args) {
		SegmentTreeRMQ segTRMQ = new SegmentTreeRMQ();
		int segTree[] = segTRMQ.createSegmentTree(new int[] { -1, 2, 4, 0 });
		
		segTRMQ.getMinimun(segTree,1,2);
		
		System.out.println(segTree);
	}
}
