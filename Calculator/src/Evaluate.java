import java.util.Stack;

public class Evaluate {
	
	private static boolean isOperator(char c) {
		
		if (c == '+' || c == '-' || c == '*' || c == '/' ) {
			return true;
		}
		return false;
	}
	
	public static String computePostfix(String postfix) {
		String s = "";
		if (!postfix.contains(".")) {
			Stack<Integer> stack = new Stack<>();

			for (int i = 0; i < postfix.length();i++) {
				char c = postfix.charAt(i);
				
				if (c == ' ') {
					continue;
				}
				
				else if (isOperator(c)){
					int temp1 = stack.pop();
					int temp2 = stack.pop();
					
					if (c == '+') {
						stack.push((temp2 + temp1));
					}
					else if (c == '-') {
						stack.push((temp2 - temp1));
					}
					else if (c == '*') {
						stack.push((temp2 * temp1));
					}
					else if (c == '/') {
						stack.push((temp2 / temp1));
					}
				}
				else {

					String temp = "";
					temp = temp + c;
					for (int j = i + 1; j < postfix.length();j++) {
						c = postfix.charAt(j);
						if (c == ' ' || isOperator(c)) {
							break;
						}
						i = i + 1;
						temp = temp + c;
					}
					
					int j = Integer.parseInt(temp);
					stack.push(j);
				}
			}
			s = s + stack.pop();
			return s;
		}
		else {
			Stack<Double> stack = new Stack<>();
			
			for (int i = 0; i < postfix.length();i++) {
				char c = postfix.charAt(i);
				
				if (c == ' ') {
					continue;
				}
				
				else if (isOperator(c)){
					double temp1 = stack.pop();
					double temp2 = stack.pop();
					
					if (c == '+') {
						stack.push((temp2 + temp1));
					}
					else if (c == '-') {
						stack.push((temp2 - temp1));
					}
					else if (c == '*') {
						stack.push((temp2 * temp1));
					}
					else if (c == '/') {
						stack.push((temp2 / temp1));
					}
				}
				else {

					String temp = "";
					temp = temp + c;
					for (int j = i + 1; j < postfix.length();j++) {
						c = postfix.charAt(j);
						if (c == ' ' || isOperator(c)) {
							break;
						}
						i = i + 1;
						temp = temp + c;
					}
					
					double j = Double.parseDouble(temp);
					stack.push(j);
				}
			}
			s = s + stack.pop();
			return s;
		}
		

		
		
	}
	
//	public static void main(String[] args)  { 
//		String exp = "132+   245.2*    (30   -       25    )    "; 
//		String s = ToPostfix.changeFromInfixToPostfix(exp);
//		System.out.println(s);
//		System.out.println(computePostfix(s)); 
//		
//    } 
}
