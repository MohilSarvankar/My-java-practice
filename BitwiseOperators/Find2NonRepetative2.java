package BitwiseOperators;

public class Find2NonRepetative2 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,1,2,3,4,5};
		int temp = 0;
		
		for(int i: arr) {
			temp = temp^i;
		}
		
		
	}

}
