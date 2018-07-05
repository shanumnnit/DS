package my.gfg.queue.crud;

public class Tester {

	public static void main(String[] args) {
		Queue myQueue = new Queue(5);
		myQueue.dequeue();
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		myQueue.enqueue(4);
		myQueue.enqueue(5);
		myQueue.enqueue(6);
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);

		myQueue.print();
	}

}
