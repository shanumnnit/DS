package my.gfg.circular.linkedList.split.half;

public class TestLinkedList {

	public static void main(String[] args) {
		CircularLinkedList myList = new CircularLinkedList();
		myList.sortedInsert(8);
		myList.sortedInsert(5);
		myList.sortedInsert(6);
		myList.sortedInsert(10);
		myList.sortedInsert(1);
		myList.sortedInsert(0);
		myList.sortedInsert(7);
		myList.sortedInsert(99);

		myList.printList();
		

	}

}
