package my.gfg.linkedList.crud;

public class TestLinkedListCRUD {

	public static void main(String[] args) {
		LinkedList myList = new LinkedList();
		myList.insertAtEnd(2);
		myList.insertAtEnd(4);
		myList.insertAtEnd(6);

		myList.printList();

		myList.insertAt(-1, 1);
		myList.insertAt(3, 3);
		myList.insertAt(5, 5);
		myList.insertAt(99, 7);

		myList.printList();

		myList.deleteAt(4);
		myList.deleteAt(-1);
		myList.deleteAt(8);
		
		myList.printList();
	}

}
