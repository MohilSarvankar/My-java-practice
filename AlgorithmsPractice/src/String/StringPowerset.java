package String;

public class StringPowerset {
	/*
	 * It gives all possible combinations of letters of string
	 * Eg. abc = {"", a, b, c, ab, bc, ac, abc}
	 */
	public static void powerset(String s, int i, String cur) {
		if(i == s.length()) {
			System.out.println("---" + cur + "---");
			return;
		}
		powerset(s,i+1,cur+s.substring(i, i+1));
		powerset(s,i+1,cur);
	}
	
	public static void main(String[] args) {
		String s = "abc";
		powerset(s, 0, "");
	}
}
