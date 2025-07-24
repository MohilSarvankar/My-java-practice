package arrays;

import java.util.PriorityQueue;

/*
 * Refer: https://youtu.be/Eb1A6nm_Nic?si=OdV3WIYHOzlBcn3S
 */
public class ConnectNRopesWithMinimumCost {
	
	public static int connectRopes(int[] a) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = a.length;
		int cost = 0;
		
		for(int i=0; i<n; i++) {
			pq.add(a[i]);
		}
		
		while(pq.size() > 1) {
			int first = pq.poll();
			int second = pq.poll();
			int sum = first + second;
			cost += sum;
			pq.add(sum);
		}
		
		return cost;
	}
	
	public static void main(String[] args) {
		int[] a = {9,2,5,4,8,6};
		int cost = connectRopes(a);
		System.out.println("Minimum cost to connect ropes: "+ cost);
	}
}
