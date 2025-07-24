package binarySearchTree;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import binaryTree.BinaryTree;
import binaryTree.Node;

/*
 * Check whether given BST contains pair of nodes with given sum
 */
public class PairWithGivenSum {
	
	static boolean isPairPresent(Node root, int sum, Set<Integer> set) {
		if(root == null)
			return false;
		
		if(isPairPresent(root.left, sum, set))
			return true;
		
		if(set.contains(sum - root.data))
			return true;
		
		set.add(root.data);
		
		return isPairPresent(root.right, sum, set);
	}
	
	public static void main(String[] args) {
		Node root = BinaryTree.createTree();
		Set<Integer> set = new HashSet<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter target sum: ");
		int sum = sc.nextInt();
		
		System.out.println("Is sum present: " + isPairPresent(root, sum, set));
	}
}
