package BitwiseOperators;

public class Find1NonRepetative2 {

	public static void main(String[] args) {
		int[] arr = {5,4,3,2,3,2,4};
		int res = 0;
		
		for(int i: arr) {
			res = res^i;
		}
		
		System.out.println("Non repetative number: " + res);
	}

}
