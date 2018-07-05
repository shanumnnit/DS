package my.gfg.linkedList.sorted.mergesort;

public class Tester {

	public static void main(String[] args) {
		LinkedList myList = new LinkedList();
		myList.insertAtEnd(8);
		myList.insertAtEnd(3);
		myList.insertAtEnd(32);
		myList.insertAtEnd(3);
		myList.insertAtEnd(5);
		myList.insertAtEnd(98);
		myList.insertAtEnd(1);

		myList.sort();

		myList.printList();

	}

}
