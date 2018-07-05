package my.gfg.circular.linkedList.sorted.insert;

public class TestLinkedList {

	public static void main(String[] args) {
		CircularLinkedList myList = new CircularLinkedList();
		myList.insertAtEnd(4);
		myList.insertAtEnd(5);
		myList.insertAtEnd(6);
		myList.insertAtEnd(7);
		myList.insertAtEnd(8);
		myList.insertAtEnd(9);
		myList.insertAtBeggining(3);
		myList.insertAtBeggining(2);
		myList.insertAtBeggining(1);

		myList.printList();
		
		myList.splitIntoHalf();
		
		myList.printList1();
		myList.printList2();

	}

}
