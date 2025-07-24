package binarySearchTree;

import java.util.Scanner;

import binaryTree.BinaryTree;
import binaryTree.Node;

/*
 * We will be given a key. We have to find out floor and ceil value for that key from BST.
 * Refer: https://youtu.be/Sgz3SF_0wOw?si=ZYWgQCphe0yJXMR8
 */
public class FloorCeilValueInBST {
	
	static int floor(Node root, int key) {
		int ans = Integer.MAX_VALUE;
		while(root != null) {
			if(root.data == key)
				return root.data;
			
			if(root.data > key) {
				root = root.left;
			}
			else {
				ans = root.data;
				root = root.right;
			}
		}
		return ans;
	}
	
	static int ceil(Node root, int key) {
		int ans = Integer.MIN_VALUE;
		while(root != null) {
			if(root.data == key)
				return root.data;
			
			if(root.data < key) {
				root = root.right;
			}
			else {
				ans = root.data;
				root = root.left;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Node root = BinaryTree.createTree();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter key: ");
		int key = sc.nextInt();
		
		System.out.println("Floor value of " + key + ": " + floor(root, key));
		System.out.println("Ceil value of " + key + ": " + ceil(root, key));
	}
}
