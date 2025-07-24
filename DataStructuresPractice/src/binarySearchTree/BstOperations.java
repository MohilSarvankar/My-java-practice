package binarySearchTree;

import java.util.Scanner;

import binaryTree.BinaryTree;
import binaryTree.Node;

/*
 * We are doing search, insert and delete in binary search tree.
 */
public class BstOperations {
	
	static boolean search(Node root, int key) {
		if(root == null) return false;
		
		if(key < root.data) 
			return search(root.left, key);
		else if(key > root.data) 
			return search(root.right, key);
		else
			return true;
	}
	
	//recurssive method
	static Node insertNode1(Node root, int key) {
		if(root == null)
			return new Node(key);
		
		if(key < root.data)
			root.left = insertNode1(root.left, key);
		else
			root.right = insertNode1(root.right, key);
		
		return root;
	}
	
	//iterative method
	static Node insertNode2(Node root, int key) {
		Node parent = null;
		Node cur = root;
		Node newNode = new Node(key);
		
		while(cur != null) {
			parent = cur;
			if(key < cur.data)
				cur = cur.left;
			else
				cur = cur.right;
		}
		
		if(parent == null)
			return newNode;
		
		if(key < parent.data)
			parent.left = newNode;
		else
			parent.right = newNode;
		
		return root;
	}
	
	static Node deleteNode(Node root, int key) {
		if(root == null)
			return null;
		
		if(key < root.data)
			root.left = deleteNode(root.left, key);
		else if(key > root.data)
			root.right = deleteNode(root.right, key);
		else {
			if(root.left == null)
				return root.right;
			
			if(root.right == null)
				return root.left;
			
			int min = minValue(root.right);
			root.data = min;
			root.right = deleteNode(root.right, min);
		}
		
		return root;
	}
	
	static int minValue(Node root) {
		int min = root.data;
		while(root.left != null) {
			min = root.left.data;
			root = root.left;
		}
		return min;
	}

	public static void main(String[] args) {
		Node root = BinaryTree.createTree();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Binary search tree: ");
		BinaryTree.inOrder(root);
		
		System.out.println("Enter value to search: ");
		int key = sc.nextInt();
		System.out.println("Is present: " + search(root, key));
		
		System.out.println("Enter 1st value to insert: ");
		key = sc.nextInt();
		root = insertNode1(root, key);
		
		System.out.println("Binary search tree: ");
		BinaryTree.inOrder(root);
		
		System.out.println("Enter 2nd value to insert: ");
		key = sc.nextInt();
		root = insertNode2(root, key);
		
		System.out.println("Binary search tree: ");
		BinaryTree.inOrder(root);
		
		System.out.println("Enter value to delete: ");
		key = sc.nextInt();
		root = deleteNode(root, key);
		
		System.out.println("Binary search tree: ");
		BinaryTree.inOrder(root);
	}

}
