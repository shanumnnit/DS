package my.gfg.doubly.linkedList.quick.sort;

public class TestLinkedListCRUD {

	public static void main(String[] args) {
		DoublyLinkedList myList = new DoublyLinkedList();
		myList.insertAtEnd(1);
		myList.insertAtEnd(2);
		myList.insertAtEnd(3);
		myList.insertAtEnd(4);
		myList.insertAtEnd(5);

		myList.printList();
		myList.reverse();
		myList.printList();

	}

}
