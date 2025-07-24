package stream;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Refer: https://youtu.be/Yv2jzDzYlp8?si=07UbqjaVCh14P73a
 */
public class MedianOfStream {
	
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	
	public void insertNum(int num) {
		if(maxHeap.isEmpty() || num < maxHeap.peek())
			maxHeap.add(num);
		else
			minHeap.add(num);
		
		if(maxHeap.size() > minHeap.size() + 1)
			minHeap.add(maxHeap.poll());
		else if(minHeap.size() > maxHeap.size())
			maxHeap.add(minHeap.poll());
	}
	
	public double findMedian() {
		if(maxHeap.size() == minHeap.size())
			return (maxHeap.peek() + minHeap.peek())/2.0;
		return maxHeap.peek();
	}
	
	public static void main(String[] args) {
		MedianOfStream medianOfStream = new MedianOfStream();
		medianOfStream.insertNum(3);
		medianOfStream.insertNum(2);
		System.out.println("Meadian of stream: "+ medianOfStream.findMedian());
		medianOfStream.insertNum(6);
		medianOfStream.insertNum(1);
		medianOfStream.insertNum(8);
		System.out.println("Meadian of stream: "+ medianOfStream.findMedian());
		medianOfStream.insertNum(4);
		System.out.println("Meadian of stream: "+ medianOfStream.findMedian());
	}
}
