package binaryTree;

public class TreeOperations {
	
	static int height(Node root) {
		if(root == null)
			return 0;
		return Math.max(height(root.left), height(root.right)) + 1;
	}
	
	static int size(Node root) {
		if(root == null)
			return 0;
		return size(root.left) + size(root.right) + 1;
	}
	
	static int maximum(Node root) {
		if(root == null)
			return Integer.MIN_VALUE;
		return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
	}
	
	static int minimum(Node root) {
		if(root == null)
			return Integer.MAX_VALUE;
		return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
	}

	public static void main(String[] args) {
		Node root = BinaryTree.createTree();
		System.out.println("Height of binary tree: "+ height(root));
		System.out.println("Size of binary tree: "+ size(root));
		System.out.println("Maximum of binary tree: "+ maximum(root));
		System.out.println("Minimum of binary tree: "+ minimum(root));
	}

}
