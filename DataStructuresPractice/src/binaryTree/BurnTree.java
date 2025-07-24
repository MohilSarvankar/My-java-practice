package binaryTree;

import java.util.Scanner;

/*
 * Maximum time required to burn binary tree starting from leaf node
 * Refer: https://youtu.be/gvH2RACiR4Y?si=E7XSIiAJ4q63SNpk
 */
public class BurnTree {
	
	static class Depth{
		int d;
		public Depth(int d) {
			this.d = d;
		}
	}
	
	static int ans = -1;
	static int burn(Node root, int target, Depth depth) {
		if(root == null) return 0;
		if(root.data == target) {
			depth.d = 1;
			return 1;
		}
		
		Depth ld = new Depth(-1);
		Depth rd = new Depth(-1);
		
		int lh = burn(root.left, target, ld);
		int rh = burn(root.right, target, rd);
		
		if(ld.d != -1) {
			ans = Math.max(ans, ld.d + 1 + rh);
			depth.d = ld.d + 1;
		}
		else if(rd.d != -1) {
			ans = Math.max(ans, rd.d + 1 + lh);
			depth.d = rd.d + 1;
		}
		
		return Math.max(lh, rh) + 1;
	}
	
	public static void main(String[] args) {
		Node root = BinaryTree.createTree();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter target node to burn: ");
		int target = sc.nextInt();
		
		Depth depth = new Depth(-1);
		
		burn(root, target, depth);
		
		System.out.println("Max time to burn: "+ ans);
	}
}
