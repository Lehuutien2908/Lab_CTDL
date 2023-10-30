package lab6;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		return (isEmpty()) ? null : head.getData();
	}

	public E last() {
		return (isEmpty()) ? null : tail.getData();
	}

	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
		size++;
	}

	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}

	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}

		E oldElement = head.getData();
		head = head.getNext();
		size--;

		if (isEmpty()) {
			tail = null;
		}

		return oldElement;
	}

	public E removeLast() {
		if (isEmpty()) {
			return null;
		}

		E oldElement;
		if (size == 1) {
			oldElement = tail.getData();
			head = tail = null;
		} else {
			Node<E> cur = head;
			while (cur.getNext() != tail) {
				cur = cur.getNext();
			}
			oldElement = tail.getData();
			cur.setNext(null);
			tail = cur;
		}
		size--;
		return oldElement;
	}
}
