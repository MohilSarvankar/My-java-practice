package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
	
	static List<Integer> verticalOrder(Node root){
		Queue<Pair> q = new ArrayDeque<>();
		Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
		
		q.offer(new Pair(root, 0));
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			
			if(map.containsKey(cur.hd))
				map.get(cur.hd).add(cur.node.data);
			else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(cur.node.data);
				map.put(cur.hd, list);
			}
			
			if(cur.node.left != null)
				q.offer(new Pair(cur.node.left, cur.hd - 1));
			
			if(cur.node.right != null)
				q.offer(new Pair(cur.node.right, cur.hd + 1));
		}
		
		List<Integer> ans = new ArrayList<>();
		for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()) {
			ans.addAll(entry.getValue());
		}
		
		return ans;
	}
	
	static class Pair{
		Node node;
		int hd;
		public Pair(Node node, int hd){
			this.node = node;
			this.hd = hd;
		}
	}
	
	public static void main(String[] args) {
		Node root = BinaryTree.createTree();
		List<Integer> res = verticalOrder(root);
		
		for(int i: res) {
			System.out.print(i + " ");
		}
	}
}
