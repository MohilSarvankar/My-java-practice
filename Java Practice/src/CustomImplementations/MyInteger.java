package CustomImplementations;

public final class MyInteger implements Comparable<MyInteger>{
	
	private final int value;
	private static final int low = -128;
	private static final int high = 127;
	private static final MyInteger[] cache;
	
	static {
		cache = new MyInteger[high-low+1];
		
		for(int i=low; i<=high; i++)
			cache[i-low] = new MyInteger(i);
	}
	
	public MyInteger(int value) {
		this.value = value;
	}
	
	//Using caching here
	public static MyInteger valueOf(int value) {
		if(value >= low && value <= high)
			return cache[value];
		
		return new MyInteger(value);
	}
	
	public int intValue() {
		return this.value;
	}
	
	@Override
	public int hashCode() {
		return Integer.hashCode(this.value);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null || !(obj instanceof MyInteger)) 
			return false;
		
		MyInteger i = (MyInteger) obj;
		return i.value == this.value;
	}

	@Override
	public String toString() {
		return String.valueOf(this.value);
	}

	@Override
	public int compareTo(MyInteger o) {
		return this.value - o.value;
	}
	
	public MyInteger add(MyInteger obj) {
		return new MyInteger(this.value + obj.value);
	}
	
	public MyInteger subtract(MyInteger obj) {
		return new MyInteger(this.value - obj.value);
	}
	
	public MyInteger multiply(MyInteger obj) {
		return new MyInteger(this.value * obj.value);
	}
	
	public MyInteger divide(MyInteger obj) {
		return new MyInteger(this.value / obj.value);
	}

}
