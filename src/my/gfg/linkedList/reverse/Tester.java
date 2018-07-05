package my.gfg.linkedList.reverse;

public class Tester {

	public static void main(String[] args) {
		LinkedList myList = new LinkedList();
		myList.insertAtEnd(1);
		myList.insertAtEnd(2);
		myList.insertAtEnd(3);
		myList.insertAtEnd(4);
		myList.insertAtEnd(5);
		myList.insertAtEnd(6);
		myList.insertAtEnd(7);
		myList.insertAtEnd(8);
		myList.insertAtEnd(9);

		myList.printList();
		
		myList.reverse();
		
		myList.printList();
		
	}

}
