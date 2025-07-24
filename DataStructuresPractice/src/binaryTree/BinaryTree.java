package binaryTree;

import java.util.Scanner;

public class BinaryTree {
	
	public static Node createTree() {
		Scanner sc = new Scanner(System.in);
		Node root = null;
		
		System.out.println("Enter data: ");
		int data = sc.nextInt();
		
		if(data == -1)
			return null;
		
		root = new Node(data);
		
		System.out.println("Enter left for "+ data);
		root.left = createTree();
		
		System.out.println("Enter right for "+ data);
		root.right = createTree();
		
		return root;
	}
	
	public static void inOrder(Node root) {
		if(root == null) return;
		
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public static void preOrder(Node root) {
		if(root == null) return;
		
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void postOrder(Node root) {
		if(root == null) return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	public static void main(String[] args) {
		Node root = createTree();
		System.out.print("Inorder: ");
		inOrder(root);
		System.out.print("\nPreorder: ");
		preOrder(root);
		System.out.print("\nPostorder: ");
		postOrder(root);
	}

}
