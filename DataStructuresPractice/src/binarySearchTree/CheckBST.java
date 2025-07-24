package binarySearchTree;

import binaryTree.BinaryTree;
import binaryTree.Node;

/*
 * Check if given binary tree is BST.
 * Refer: https://youtu.be/9btwHI_84DM?si=sqr5yoV9c_pzYS1A
 */
public class CheckBST {
	
	//Using range
	static boolean isBST1(Node root, int min, int max) {
		if(root == null)
			return true;
		
		if(root.data < min || root.data > max)
			return false;
		
		return isBST1(root.left, min, root.data - 1) && isBST1(root.right, root.data + 1, max);
	}
	
	//Using inorder traversal and storing previous variable
	static Node prev = null;
	static boolean isBST2(Node root) {
		if(root == null) 
			return true;
		
		if(!isBST2(root.left))
			return false;
		
		if(prev != null && root.data <= prev.data)
			return false;
		
		prev = root;
		
		return isBST2(root.right);
	}
	
	public static void main(String[] args) {
		Node root = BinaryTree.createTree();
		System.out.println("Is BST 1: " + isBST1(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println("Is BST 2: " + isBST2(root));
	}
}
