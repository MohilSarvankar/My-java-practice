package stack;

import java.util.Stack;

public class ParenthesisMatching {
	
	public static boolean isPrenthesisMatching(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(' || c == '[' || c =='{') {
				stack.push(c);
			}
			else {
				if(stack.isEmpty())
					return false;
				else if(c == ']' && stack.pop() != '[')
					return false;
				else if(c == ')' && stack.pop() != '(')
					return false;
				else if(c == '}' && stack.pop() != '{')
					return false;
			}
		}
		
		if(!stack.isEmpty())
			return false;
		
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPrenthesisMatching("{}[(())]"));
	}

}
