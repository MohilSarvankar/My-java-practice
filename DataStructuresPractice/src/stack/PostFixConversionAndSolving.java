package stack;

import java.util.Stack;

public class PostFixConversionAndSolving {
	
	public static String convertToPostfix(String exp) {
		Stack<Character> s = new Stack<>();
		String res = "";
		
		for(int i=0; i<exp.length(); i++) {
			char c = exp.charAt(i);
			if(Character.isDigit(c)){
				res += c;
			}
			else if(c == '(') {
				s.push(c);
			}
			else if(c == ')') {
				while(!s.isEmpty() && s.peek() != '(') {
					res += s.pop();
				}
				s.pop();
			}
			else {
				if(s.isEmpty()) {
					s.push(c);
				}
				else {
					while(!s.isEmpty() && (s.peek()=='*' || s.peek()=='/')) {
						res += s.pop();
					}
					s.push(c);
				}
			}
		}
		
		while(!s.isEmpty())
			res += s.pop();
		
		return res;
	}
	
	public static int solvePostfix(String exp) {
		Stack<Integer> s = new Stack<>();
		int res = 0;
		
		for(int i=0; i<exp.length(); i++) {
			char c = exp.charAt(i);
			if(Character.isDigit(c)) {
				s.push(c - '0');
			}
			else {
				int second = s.pop();
				int first = s.pop();
				if(c == '/')
					res = first / second;
				else if(c == '*')
					res = first * second;
				else if(c == '+')
					res = first + second;
				else if(c == '-')
					res = first - second;
				s.push(res);
			}
		}
		
		return (int)s.pop();
	}
	
	public static void main(String[] args) {
		System.out.println(convertToPostfix("(3+2)*7-4"));
		System.out.println(convertToPostfix("4*2/(3+1)*5"));
		
		String postfix = convertToPostfix("4*2/(3+1)*5");
		System.out.println("Result: "+solvePostfix(postfix));
	}
}
