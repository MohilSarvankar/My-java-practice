package CustomImplementations;

import java.util.Arrays;

public class MyList<T>{
	
	private static final int defaultSize = 10;
	private static final double increaseFactor = 0.5;
	
	private Object[] arr;
	private int size;
	
	public MyList() {
		size = 0;
		arr = new Object[defaultSize];
	}
	
	public void add(T t) {
		if(size == arr.length) {
			arr = Arrays.copyOf(arr, (int)(size + size * increaseFactor));
		}
		arr[size] = t;
		size++;
	}
	
	public T get(int i) {
		return (T)arr[i];
	}
	
	public void remove(int i) {
		System.arraycopy(arr, i+1, arr, i, size-1);
		size--;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=0; i<size; i++) {
			sb.append(arr[i] + ",");
		}
		sb.replace(sb.length()-1,sb.length(), "]");
		return sb.toString();
	}
}
