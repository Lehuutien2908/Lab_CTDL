package lab6;

public class TestMyLinkedList {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		list.addFirst(2);// test addFirst
		list.addFirst(1);// test addFirst
		list.addLast(4);// test addLast
//		System.out.println(list.size());//test size
//		System.out.println(list.isEmpty());//test isEmpty
//		System.out.println(list.first());//test First
//		System.out.println(list.last());//test Last
		System.out.println(list.removeFirst());// test removeF
		System.out.println(list.removeLast());// test removeL

	}
}
