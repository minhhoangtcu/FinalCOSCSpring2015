package datastructure.trees.binarysearchtree;

public class Tree<T extends Comparable<T>> {
	
	Node<T> root;
	
	public Tree() {
		root = null;
	}

	public void push(T data) {
		Node<T> newNode = new Node<>(data);
		
		if (isEmpty()) {
			root = newNode;
		}
		else {
			Node<T> current = root, previous = null;
			
			while (current != null) {
				int compare = newNode.data.compareTo(current.data);
				if (compare < 0) {
					previous = current;
					current = current.left;
					if (current == null) {
						previous.left = newNode;
					}
				}
				else if (compare > 0) {
					previous = current;
					current = current.right;
					if (current == null) {
						previous.right = newNode;
					}
				}
				else break; // ignore the case for same node insertion.
			}
		}
	}
	
	public T floor(T data) {
		Node<T> x = floor(root, data);
		if (x == null)
			return null;
		else
			return x.data;
	}
	
	/**
	 * Find the floor of a given data within the tree recursively.
	 * @param node
	 * @param data
	 * @return
	 */
	private Node<T> floor(Node<T> node, T data) {
		if (node == null)
			return null;
		else {
			int comp = data.compareTo(node.data);
			if (comp == 0) // Found a node similar that has the same key with the provided key, so this must be the floor
				return node;
			else if (comp < 0)
				return floor(node.left, data); // If the node key is less than the key, then the floor must be on the left
			else {
				Node<T> right = floor(node.right, data); // If the node key is more than the key, the floor may be on the right. 
													     // If there is one, return it. If not, return the parent.
				if (right != null) 
					return right;
				else
					return node;
			}
		}
	}
	
	public T ceil(T data) {
		Node<T> x = ceil(root, data);
		if (x == null)
			return null;
		else
			return x.data;
	}
	
	/**
	 * Find the ceiling of a given data within the tree recursively
	 * @param node
	 * @param data
	 * @return
	 */
	private Node<T> ceil(Node<T> node, T data) {
		if (node == null)
			return null;
		else {
			int comp = data.compareTo(node.data);
			if (comp == 0) // Found a node similar that has the same key with the provided key, so this must be the ceil
				return node;
			else if (comp > 0)
				return ceil(node.right, data);
			else {
				Node<T> left = ceil(node.left, data);
				
				if (left != null)
					return left;
				else
					return node;
			}
		}
	}

	public void push(T[] input) {
		for (T each: input) {
			push(each);
		}
	}
	
	public void showInOrder() {
		
	}
	
	public boolean isEmpty() {
		return (root == null);
	}
	
}
