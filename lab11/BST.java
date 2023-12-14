package lab11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	public void add(E e) {
		if (root == null)
			this.root = new BNode<>(e);
		this.root.add(e);
	}

	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	public int dept(E node) {
		if (root == null)
			return -1;
		return this.root.dept(node);
	}

	public int height() {
		if (root == null)
			return -1;
		return this.root.height();
	}

	public int size() {
		if (root == null)
			return -1;
		return this.root.size();
	}

	public boolean contains(E e) {
		if (root == null)
			return false;
		return this.root.contains(e);
	}

	public E findMin() {
		if (root == null)
			return null;
		return this.root.findMin();
	}

	public E findMax() {
		if (root == null)
			return null;
		return this.root.findMax();
	}
	public List<E> descendants(E data) {
		if(root == null)
			return null;
		return this.root.descendants(data);
	}
	public List<E> ancestors(E data) {
		if (root == null)
			return null;
		return this.root.ancestors(data);

	}
	private void inorderTraversal(BNode<E> node) {
		if (node != null) {
			inorderTraversal(node.getLeft());
			System.out.print(node.getData() + " ");
			inorderTraversal(node.getRight());
		}
	}

	public void inOrder() {
		inorderTraversal(root);
	}

	private void preorderTraversal(BNode<E> node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			preorderTraversal(node.getLeft());
			preorderTraversal(node.getRight());
		}
	}

	public void preOrder() {
		preorderTraversal(root);
	}

	private void postorderTraversal(BNode<E> node) {
		if (node != null) {
			postorderTraversal(node.getLeft());
			postorderTraversal(node.getRight());
			System.out.print(node.getData() + " ");
		}
	}

	public void postOrder() {
		postorderTraversal(root);
	}
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();

		bst.add(25);
		bst.add(15);
		bst.add(50);
		bst.add(10);
		bst.add(22);
		bst.add(70);
		bst.add(35);
		bst.add(4);
		bst.add(12);
		bst.add(24);
		bst.add(18);
		bst.add(44);
		bst.add(31);
		bst.add(90);
		bst.add(66);

		System.out.println("Dept's node is : " + bst.dept(35));
		System.out.println("Height's BST is : " + bst.height());
		System.out.println("Size is: " + bst.size());
		System.out.println("Contains : " + bst.contains(44));
		System.out.println("findMin : " + bst.findMin());
		System.out.println("findMax : " + bst.findMax());
		List<Integer> descendantsList = bst.descendants(50);
		List<Integer> ancestorsList = bst.ancestors(35);
		System.out.println("Descendants is: " + descendantsList);
		System.out.println("Ancestors is: " + ancestorsList);
		System.out.println("Inoder : ");
		bst.inOrder();
		System.out.println();
		System.out.println("Preoder : ");
		bst.preOrder();
		System.out.println();
		System.out.println("Postoder : ");
		bst.postOrder();
	}
}
