package asg1_salehh6;
import java.util.Scanner;

/**
 * Question 3
 */
public class Parentheses {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		System.out.println("Enter your text to check if the parentheses match:");
		sb.append(sc.nextLine());
		sc.close();
		
		String str = sb.toString();
		
		System.out.println(validParentheses(str));
	}
	
	public static boolean validParentheses(String s) {
		Stack stack = new Stack();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(Character.toString(s.charAt(i)));
			} else if (s.charAt(i) == '{') {
				stack.push(Character.toString(s.charAt(i)));
			} else if (s.charAt(i) == '[') {
				stack.push(Character.toString(s.charAt(i)));
			} else if (s.charAt(i) == ')') {
				if (stack.peek().equals("(")) {
					stack.pop();
				} else return false;
			} else if (s.charAt(i) == '}') {
				if (stack.peek().equals("{")) {
					stack.pop();
				} else return false;
			} else if (s.charAt(i) == ']') {
				if (stack.peek().equals("[")) {
					stack.pop();
				} else return false;
			}
		} 
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}
}
