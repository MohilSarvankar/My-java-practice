package binaryTree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

/*
 * Left, right, top, bottom views of binary tree
 * Refer for left and right: https://youtu.be/Lcre2oZh5YM?si=oluBUzeBi6siizDA
 * Refer for top and bottom: https://youtu.be/wTloJwckQTU?si=0mFwmZk0QxiVEVbH
 */
public class TreeViews {
	
	//left view
	static void leftViewUtil(Node root, Map<Integer, Node> map, int level) {
		if(root == null)
			return;
		if(!map.containsKey(level))
			map.put(level, root);
		leftViewUtil(root.left, map, level+1);
		leftViewUtil(root.right, map, level+1);
	}
	
	static void printLeftView(Node root) {
		Map<Integer, Node> map = new HashMap<>();
		leftViewUtil(root, map, 0);
		for(Entry<Integer, Node> e: map.entrySet()) {
			System.out.print(e.getValue().data + " ");
		}
		System.out.println();
	}
	
	//right view
	static void rightViewUtil(Node root, Map<Integer, Node> map, int level) {
		if(root == null)
			return;
		map.put(level, root);
		rightViewUtil(root.left, map, level+1);
		rightViewUtil(root.right, map, level+1);
	}
	
	static void printRightView(Node root) {
		Map<Integer, Node> map = new HashMap<>();
		rightViewUtil(root, map, 0);
		for(Entry<Integer, Node> e: map.entrySet()) {
			System.out.print(e.getValue().data + " ");
		}
		System.out.println();
	}
	
	//top view
	static void printTopView(Node root) {
		Queue<Pair> q = new ArrayDeque<>();
		Map<Integer, Integer> map = new TreeMap<>();
		
		q.offer(new Pair(root, 0));
		
		while(!q.isEmpty()) {
			Pair temp = q.poll();
			
			if(!map.containsKey(temp.hd)) {
				map.put(temp.hd, temp.node.data);
			}
			
			if(temp.node.left != null)
				q.offer(new Pair(temp.node.left, temp.hd - 1));
			
			if(temp.node.right != null)
				q.offer(new Pair(temp.node.right, temp.hd + 1));
		}
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
		System.out.println();
	}
	
	//bottom view
	static void printBottomView(Node root) {
		Queue<Pair> q = new ArrayDeque<>();
		Map<Integer, Integer> map = new TreeMap<>();
		
		q.offer(new Pair(root, 0));
		
		while(!q.isEmpty()) {
			Pair temp = q.poll();
			
			map.put(temp.hd, temp.node.data);
			
			if(temp.node.left != null)
				q.offer(new Pair(temp.node.left, temp.hd - 1));
			
			if(temp.node.right != null)
				q.offer(new Pair(temp.node.right, temp.hd + 1));
		}
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node root = BinaryTree.createTree();
		
		System.out.print("Left view: ");
		printLeftView(root);
		
		System.out.print("Right view: ");
		printRightView(root);
		
		System.out.print("Top view: ");
		printTopView(root);
		
		System.out.print("Bottom view: ");
		printBottomView(root);
	}
	
	static class Pair{
		Node node;
		int hd;
		
		Pair(Node node, int hd){
			this.node = node;
			this.hd = hd;
		}
	}

}
