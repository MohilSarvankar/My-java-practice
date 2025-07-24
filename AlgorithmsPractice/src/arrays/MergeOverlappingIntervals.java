package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Merge Overlapping Sub-intervals
 * Refer: https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/
 */
public class MergeOverlappingIntervals {

	//Optimal approach
	public static int[][] mergeIntervals1(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		List<int[]> list = new ArrayList<>();
		int n = intervals.length;
		int start = 0;
		int end = 0;
		int j = 0;
		list.add(intervals[0]);
		
		for(int i=1; i<n; i++) {
			start = intervals[i][0];
			end = intervals[i][1];
			
			if(start <= list.get(j)[1]) {
				list.get(j)[1] = Math.max(list.get(j)[1], end);
			}
			else {
				list.add(intervals[i]);
				j++;
			}
		}
		
		int[][] ans = new int[j+1][2];
		for(int i=0; i<j+1; i++) {
			ans[i] = list.get(i);
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		int[][] arr = {{8,10},{15,18},{1,3},{2,6}};
		int[][] ans = mergeIntervals1(arr);
		System.out.println("Merged intervals: ");
		for(int[] i: ans) {
			System.out.print("["+i[0]+","+i[1]+"]");
		}
	}
}
