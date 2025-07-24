package String;

public class PermutationOfString {
	/*
	 * This function will return all the permutations of the given string.
	 * Eg. abc = {abc, acb, bac, bca, cab, cba}
	 */
	public static void permute(String s, int l, int r) {
		if(l == r) {
			System.out.println(s);
			return;
		}
		for(int i=l; i<=r; i++) {
			s = swap(s,l,i);
			permute(s,l+1,r);
			s = swap(s,l,i);
		}
	}
	
	public static String swap(String s, int a, int b) {
		char[] chars = s.toCharArray();
		char temp = chars[a];
		chars[a] = chars[b];
		chars[b] = temp;
		String res = "";
		for(char c: chars) {
			res += String.valueOf(c);
		}
		return res;
 	}

	public static void main(String[] args) {
		String s = "abc";
		permute(s, 0, 2);
	}

}
