package binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversal {
	
	static void printCurrentLevel(Node root, int level) {
		if(root == null)
			return;
		
		if(level == 1) {
			System.out.print(root.data + " ");
		}
		else if(level > 1) {
			printCurrentLevel(root.left, level-1);
			printCurrentLevel(root.right, level-1);
		}
	}
	
	static void levelOrder1(Node root) {
		int h = TreeOperations.height(root);
		for(int i=1; i<=h; i++) {
			printCurrentLevel(root, i);
			// If we want every level on new line
//			System.out.println();
		}
	}
	
	static void levelOrder2(Node root) {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			System.out.print(cur.data + " ");
			if(cur.left != null)
				q.offer(cur.left);
			if(cur.right != null)
				q.offer(cur.right);
		}
	}
	
	//If we want every level on new line
	static void levelOrder3(Node root) {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(root);
		q.offer(null);
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur == null) {
				if(q.isEmpty())
					return;
				q.offer(null);
				System.out.println();
				continue;
			}
			System.out.print(cur.data + " ");
			if(cur.left != null)
				q.offer(cur.left);
			if(cur.right != null)
				q.offer(cur.right);
		}
	}
	
	public static void main(String[] args) {
		Node root = BinaryTree.createTree();
		System.out.println("Level order 1: ");
		levelOrder1(root);
		System.out.println("Level order 2: ");
		levelOrder2(root);
		System.out.println("Level order 3: ");
		levelOrder3(root);
	}
}
