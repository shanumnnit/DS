package my.gfg.doubly.linkedList.reverse;

public class TestLinkedListCRUD {

	public static void main(String[] args) {
		DoublyLinkedList myList = new DoublyLinkedList();
		myList.insertAtEnd(2);
		myList.insertAtEnd(3);
		myList.insertAtEnd(73);
		myList.insertAtEnd(1);
		myList.insertAtEnd(4);
		myList.insertAtEnd(10);
		myList.insertAtEnd(7);
		myList.insertAtEnd(5);
		myList.insertAtEnd(110);
		myList.insertAtEnd(12);
		myList.insertAtEnd(48);
		myList.insertAtEnd(60);

		myList.printList();
		myList.quickSort();
		myList.printList();

	}

}
