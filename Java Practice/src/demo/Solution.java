package demo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Solution{
	
	public static void main(String[] args) {
		for(int i=1; i<=3; i++) {
			MyThread thread = new MyThread(i);
			Thread myThread = new Thread(thread);
			myThread.start();
		}
		
		for(int i=1; i<=5; i++) {
			System.out.println("Main thread - " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyThread implements Runnable {
	
	private int threadNumber;
	
	public MyThread(int threadNumber) {
		this.threadNumber = threadNumber;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=5; i++) {
			System.out.println(i + " from thread - " + threadNumber);
			try {
				Thread.sleep(1000);
				if(threadNumber == 2)
					throw new RuntimeException();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}