package my.gfg.heap.binary.crud;

public class BinaryHeap {
	int heapArr[], size, capacity;

	public BinaryHeap(int capacity) {
		this.heapArr = new int[capacity];
		this.size = -1;
		this.capacity = capacity;
	}

	public void insert(int data) {
		if (size + 1 > capacity - 1) {
			System.out.println("Heap full!!");
			return;
		}
		heapArr[++size] = data;
		heapifyUp();
	}

	public int removeMin() {
		if (size < 0) {
			System.out.println("Empty heap!!");
			return Integer.MAX_VALUE;
		}
		int toBeReturned = heapArr[0];
		heapArr[0] = heapArr[size--];
		heapifyDown();
		return toBeReturned;

	}

	private void heapifyUp() {
		int i = size;
		int parentI = getParentIndex(i);
		while (parentI >= 0 && heapArr[parentI] > heapArr[i]) {
			int temp = heapArr[parentI];
			heapArr[parentI] = heapArr[i];
			heapArr[i] = temp;
			i = parentI;
			parentI = getParentIndex(parentI);
		}
	}

	private void heapifyDown() {
		int i = 0;

		if (getLeftChild(i) > size)
			return;
		int smallerChildIndex = getLeftChild(i);
		int smallerChild = heapArr[smallerChildIndex];
		while (smallerChildIndex <= size) {
			if (getRightChild(i) <= size && heapArr[getRightChild(i)] < smallerChild) {
				smallerChildIndex = getRightChild(i);
				smallerChild = heapArr[smallerChildIndex];
			}
			int temp = heapArr[i];
			heapArr[i] = heapArr[smallerChildIndex];
			heapArr[smallerChildIndex] = temp;

			i = smallerChildIndex;
			smallerChildIndex = getLeftChild(i);
		}
	}

	private int getLeftChild(int i) {
		return (2 * i + 1);
	}

	private int getRightChild(int i) {
		return (2 * i + 2);
	}

	private int getParentIndex(int i) {
		if (i >= 0 && i <= size) {
			return (i - 1) / 2;
		}
		return Integer.MIN_VALUE;
	}

	public void print() {
		if (size < 0) {
			System.out.println("Empty heap!!");
			return;
		}
		System.out.print("Binary heap:");
		for (int i = 0; i <= size; i++) {
			System.out.print(" " + heapArr[i]);
		}
		System.out.println();
	}
}
