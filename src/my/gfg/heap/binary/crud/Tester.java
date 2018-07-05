package my.gfg.heap.binary.crud;

public class Tester {

	public static void main(String[] args) {
		BinaryHeap bh = new BinaryHeap(10);
		bh.print();

		bh.insert(8);
		bh.insert(2);
		bh.insert(3);
		bh.insert(9);
		bh.insert(10);
		bh.insert(1);
		bh.insert(4);
		bh.insert(0);

		bh.print();

		// for (int i = 0; i <= bh.capacity; i++)
		System.out.println(bh.removeMin());
		bh.print();
	}

}
