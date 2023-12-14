package lab11;

import java.util.ArrayList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;

	public BNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public E getData() {
		return data;
	}

	public BNode<E> getLeft() {
		return left;
	}

	public BNode<E> getRight() {
		return right;
	}

	public void setData(E data) {
		this.data = data;
	}

	public void setLeft(BNode<E> left) {
		this.left = left;
	}

	public void setRight(BNode<E> right) {
		this.right = right;
	}

	public void add(E e) {
		int comp = e.compareTo(this.data);
		if (comp < 0) {
			if (left == null) {
				this.left = new BNode<>(e);
			} else {
				this.left.add(e);
			}
		} else if (comp > 0) {
			if (right == null) {
				this.right = new BNode<>(e);
			} else {
				this.right.add(e);
			}
		}
	}

	public int dept(E node) {
		int comp = node.compareTo(data);
		if (comp == 0) {
			return 0;
		} else if (comp < 0) {
			return (left != null) ? 1 + this.left.dept(node) : -1;
		} else {
			return (right != null) ? 1 + this.right.dept(node) : -1;
		}
	}

	public int height() {
		int leftHeight = (left != null) ? 1 + this.left.height() : 0;
		int rightHeight = (right != null) ? 1 + this.right.height() : 0;
		return Math.max(leftHeight, rightHeight);
	}

	public int size() {
		int leftSize = (left != null) ? this.left.size() : 0;
		int rightSize = (right != null) ? this.right.size() : 0;
		return 1 + leftSize + rightSize;
	}

	public boolean contains(E e) {
		int comp = e.compareTo(data);
		if (comp == 0) {
			return true;
		} else if (comp < 0) {
			return (left != null) ? this.left.contains(e) : false;
		} else {
			return (right != null) ? this.right.contains(e) : false;
		}
	}

	public E findMin() {
		return (left != null) ? this.left.findMin() : data;
	}

	public E findMax() {
		return (right != null) ? this.right.findMax() : data;
	}

	public List<E> descendants(E data) {
		List<E> descendantsList = new ArrayList<>();
		BNode<E> targetNode = findNode(this, data);

		if (targetNode != null) {
			collectDescendants(targetNode, descendantsList);
		}

		return descendantsList;
	}

	private BNode<E> findNode(BNode<E> currentNode, E data) {
		if (currentNode == null || currentNode.getData().equals(data)) {
			return currentNode;
		}

		if (data.compareTo(currentNode.getData()) < 0) {
			return findNode(currentNode.getLeft(), data);
		} else {
			return findNode(currentNode.getRight(), data);
		}
	}

	private void collectDescendants(BNode<E> currentNode, List<E> descendantsList) {
		if (currentNode != null) {
			collectDescendants(currentNode.getLeft(), descendantsList);
			descendantsList.add(currentNode.getData());
			collectDescendants(currentNode.getRight(), descendantsList);
		}
	}

	public List<E> ancestors(E e) {
		int comp = e.compareTo(data);
		List<E> res = new ArrayList<>();

		if (comp == 0) {
			return res;
		}
		if (left != null) {
			if (left.contains(e)) {
				res.addAll(left.ancestors(e));
				res.add(data);
			}
		}
		if (right != null) {
			if (right.contains(e)) {
				res.addAll(right.ancestors(e));
				res.add(data);
			}
		}
		return res;
	}
}