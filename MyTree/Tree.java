package MyTree;

import java.util.Scanner;

public class Tree {

	public static void main(String[] args) {
		Node root = createTree();
		
		System.out.println("Inorder traversing");
		inOrder(root);
		System.out.println("\n\nPreorder traversing");
		preOrder(root);
		System.out.println("\n\nPostorder traversing");
		postOrder(root);
	}
	
	public static Node createTree() {
		Node root = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter data: ");
		int data = sc.nextInt();
		
		if(data == -1)
			return null;
		
		root = new Node(data);
		
		System.out.println("Enter left of "+ data);
		root.left = createTree();
		
		System.out.println("Enter right of "+ data);
		root.right = createTree();
		
		return root;
	}
	
	public static void inOrder(Node root) {
		if(root == null) return;
		
		inOrder(root.left);
		System.out.print(root.data+ " ");
		inOrder(root.right);
	}
	
	public static void preOrder(Node root) {
		if(root == null) return;
		
		System.out.print(root.data+ " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void postOrder(Node root) {
		if(root == null) return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+ " ");
	}

}

class Node{
	Node left, right;
	int data;
	
	Node(int data){
		this.data = data;
	}
}
