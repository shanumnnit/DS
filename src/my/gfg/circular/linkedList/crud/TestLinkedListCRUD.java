package my.gfg.circular.linkedList.crud;

public class TestLinkedListCRUD {

	public static void main(String[] args) {
		CircularLinkedList myList = new CircularLinkedList();
		myList.insertAtEnd(4);
		myList.insertAtEnd(5);
		myList.insertAtEnd(6);
		myList.insertAtBeggining(3);
		myList.insertAtBeggining(2);
		myList.insertAtBeggining(1);

		myList.printList();

	}

}
