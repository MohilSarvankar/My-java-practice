package graph;

import java.util.Arrays;

/*
 * Disjoint set (Union and FInd operations)
 * Refer: https://youtu.be/Kptz-NVA2RE?si=S-KFtK_4G30IIDLT
 */
public class MakeFriendAreFriend {
	
	int[] p;
	int[] rank;
	int n;
	
	MakeFriendAreFriend(int n){
		p = new int[n];
		rank = new int[n];
		this.n = n;
		for(int i=0; i<n; i++) {
			p[i] = i;
		}
	}
	
	public int find(int x) {
		if(p[x] != x) 
//			return find(p[x]);
			p[x] = find(p[x]); //path compression
		return p[x];
	}

	public void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x == y) return;
//		p[y] = x;
		
//		optimization
		if(rank[x] > rank[y])
			p[y] = x;
		else if(rank[y] > rank[x])
			p[x] = y;
		else {
			p[y] = x;
			rank[x]++;
		}
		
	}
	
	public boolean areFriends(int a, int b) {
		int x = find(a);
		int y = find(b);
		return x == y;
	}
	
	public void makeFriends(int a, int b) {
		union(a,b);
	}
	
	public static void main(String[] args) {
		MakeFriendAreFriend ma = new MakeFriendAreFriend(8);
		ma.makeFriends(0, 1);
		ma.makeFriends(2, 7);
		ma.makeFriends(3, 6);
		
		System.out.println("Prent array: " + Arrays.toString(ma.p));
		System.out.println("areFriends(0, 2): " + ma.areFriends(0, 2));
		
		ma.makeFriends(0, 7);
		
		System.out.println("Prent array: " + Arrays.toString(ma.p));
		System.out.println("areFriends(0, 2): " + ma.areFriends(0, 2));
	}

}
