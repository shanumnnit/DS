package my.gfg.doubly.linkedList.crud;

public class TestLinkedListCRUD {

	public static void main(String[] args) {
		DoublyLinkedList myList = new DoublyLinkedList();
		myList.insertAtEnd(5);
		myList.insertAtEnd(6);
		myList.insertAtBeggining(3);
		myList.insertAtBeggining(2);
		myList.insertAt(4, 4);
		myList.insertAt(7, 99);
		myList.insertAt(1, -1);

		myList.printList();
		myList.deleteAt(3);
		myList.printList();

	}

}
