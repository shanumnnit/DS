package my.gfg.queue.crud;

public class Queue {
	int a[], rear, front, size;

	public Queue(int size) {
		super();
		this.size = size;
		a = new int[size];
		front = rear = -1;
	}

	public void enqueue(int ele) {
		if (((rear + 1) % size == front % size) || (front == -1 && rear + 1 == size)) {
			System.out.println("Queue Full!");
			return;
		}
		System.out.println("Enqueing " + ele);
		a[(++rear) % size] = ele;
	}

	public int dequeue() {
		if (front % size >= rear % size) {
			System.out.println("Queue Empty!");
			rear = front = -1;
			return Integer.MIN_VALUE;
		}
		System.out.println("Dequeing " + a[(front + 1) % size]);
		return a[(++front) % size];
	}

	public void print() {
		if (rear == front) {
			System.out.println("Queue Empty!");
			return;
		}
		System.out.print("Queue is :");
		for (int i = (front + 1) % size; i <= rear % size; i++)
			System.out.print(" " + a[i]);
		System.out.println();
	}
}
