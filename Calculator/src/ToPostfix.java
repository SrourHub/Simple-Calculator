import java.util.Stack; 

public class ToPostfix{
	
	private static String s = "";
	private static int Precedence(char c){ 
		if (c == '+' || c == '-') {
			return 1;
		}
		else if(c == '*' || c == '/') {
			return 2;
		} 
		
        return -1; 
    } 
	private static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' ) {
			return true;
		}
		return false;
	}
	public static String changeFromInfixToPostfix(String expression) {
		
		expression = expression.replaceAll(" ", "");
		
		Stack<Character> stack = new Stack<>(); 
		
		
		for (int i = 0; i < expression.length(); i ++) {
			char c = expression.charAt(i);
			if (c == '(') {
				stack.push(c);
			}
			else if (c == ')'){
				while (!stack.isEmpty() && stack.peek() != '(') {
					 s = s + stack.pop(); 
				}
				stack.pop();
			}
			else if (isOperator(c)){
				while (!stack.isEmpty() && Precedence(c) <= Precedence(stack.peek())){
                    s = s + stack.pop(); 
				} 
                stack.push(c);
			}
			else {
				String temp = "";
				temp = temp + c;
				for (int j = i + 1; j < expression.length();j++) {
					c = expression.charAt(j);
					if (c == ' ' || isOperator(c) || c == '(' || c == ')') {
						break;
					}
					i = i + 1;
					temp = temp + c;
				}
				s = s + temp + " ";
			}
		}
		
		while (!stack.isEmpty()){ 
            if(stack.peek() == '(') {
            	return "Invalid Expression"; 
            }
            s = s + stack.pop(); 
         } 
		
        return s; 
	}
//	
//	public static void main(String[] args)  { 
//		String exp = "132 + 245 * (30 - 25)"; 
//		
//		String s = changeFromInfixToPostfix(exp);
//		
//		System.out.println(s);
//		
//    } 

	
}
	

