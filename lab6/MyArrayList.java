package lab6;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	public void growSize() {
		if (size == elements.length) {
			E[] newElement = (E[]) new Object[elements.length * 2];
			newElement = Arrays.copyOf(elements, size);
			elements = newElement;
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E get(int i) throws IndexOutOfBoundsException {
		if (i >= size || i < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			return elements[i];
		}
	}

	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i >= size || i < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			E oldElements = elements[i];
			elements[i] = e;
			return oldElements;
		}
	}

	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}
		elements[size] = e;
		size++;
		return true;
	}

	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i > size || i < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (size == elements.length) {
			growSize();
		}
		for (int j = size; j > i; j--) {
			elements[j] = elements[j - 1];
		}
		elements[i] = e;
		size++;
	}

	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			E removeElement = elements[i];
			for (int j = i; j < size - 1; j++) {
				elements[j] = elements[j + 1];
			}
			size--;
			return removeElement;
		}
	}

	public void clear() {
		int newSize = size;
		for (int j = 0; j < newSize; j++) {
			elements[j] = null;
			size--;
		}
	}

	public int lastIndexOf(Object o) {
		int res = -1;
		for (int i = 0; i < size; i++) {
			if (elements[i] == o) {
				res = i;
			}
		}
		return res;
	}

	public E[] toArray() {
		E[] res = (E[]) new Object[size];
		for (int i = 0; i < res.length; i++) {
			res[i] = elements[i];
		}
		return res;
	}

	public MyArrayList<E> clone() {
		MyArrayList<E> newList = new MyArrayList<>();
		newList.elements = Arrays.copyOf(this.elements, this.size);
		newList.size = this.size;
		return newList;
	}

	public boolean contains(E o) {
		for (E e : elements) {
			if (e == o) {
				return true;
			}
		}
		return false;
	}

	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == o) {
				return i;
			}
		}
		return -1;
	}

	public boolean remove(E o) {
		int index = indexOf(o);
		if (index >= 0) {
			remove(index);
			return true;
		}
		return false;
	}

	public void sort(Comparator<E> c) {
		quickSort(0, size - 1, c);
	}

	private void quickSort(int low, int high, Comparator<E> c) {
		if (low < high) {
			int pi = partition(low, high, c);
			quickSort(low, pi - 1, c);
			quickSort(pi + 1, high, c);
		}
	}

	private int partition(int low, int high, Comparator<E> c) {
		E pivot = elements[high];
		int i = low - 1;
		for(int j = low; j < high; j++) {
			if(c.compare(elements[j], pivot) < 0) {
				i++;
				swap(i, j);
			}
		}
		swap(i + 1,high);
		return i + 1;
	}
	private void swap(int i, int j) {
		E temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}
}
