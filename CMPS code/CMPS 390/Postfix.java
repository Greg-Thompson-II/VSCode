// CMPS390
// Postfix.java
// Algorithms for two methods: convertToPostfix and evaluatePostfix
public class Postfix {
	/** Task: Creates a postfix expression that represents a given infix expression.
	 * @param infix a string that is a valid infix expression
	 * @return a string that is the postfix expression equivalent of infix
	 */
	/** Algorithm convertToPostfix(infix) // Convert infix to postfix expression
	 * operatorStack = a new empty stack
	 * while (infix has characters left to parse)
	 * Get an item
	 * if (item is an operand)
	 * Append it to the postfix expression
	 * else if (item == '(')
	 * operatorStack.push(item)
	 * else if (item == ')')
	 * top = operatorStack.pop()
	 * while (top is not '(') // not append '(' to postfix expression
	 * Append it to the postfix expression
	 * top = operatorStack.pop()
	 * else // item is an operator: '+', '-', '*', or '/'
	 * while (!operatorStack.empty())
	 * top = operatorStack.peek()
	 * if (item precedence <= top)
	 * Append it to the postfix expression
	 * operatorStack.pop()
	 * else
	 * break
	 * operatorStack.push(item)
	 * while (!operatorStack.empty())
	 * top = operatorStack.pop();
	 * Append it to the postfix expression
	 * return the postfix expression
	 */
	public static String convertToPostfix(String infix) {
	// ADD YOUR CODE HERE
		String postFixExpression= "";
		ArrayStack operatorStack = new ArrayStack();
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			
			if (isVariable(c)) {
				operatorStack.push(c);
				postFixExpression += operatorStack.pop();
			}
			else if (c == '(') {
				operatorStack.push(c);
			}
			else if (c == ')') {
				String top = operatorStack.peek().toString();
					while (top != "(") {
						postFixExpression += operatorStack.pop();
						operatorStack.pop();
						break;
				} 
			}
			else if (c == '+' || c == '-' || c == '*' || c == '/'){
				while (!operatorStack.isEmpty()) {
					String top = operatorStack.peek().toString();
					char top1 = top.charAt(0);
					if(getPrecedence(c) <= getPrecedence(top1)) {
						
						postFixExpression += operatorStack.pop();
					}
					else {
						break;
					}
				}
				
				operatorStack.push(c);

			}
	}
		
	while (!operatorStack.isEmpty()) {
		if ( operatorStack.peek().toString() == "(") {
			operatorStack.pop();
		}
		
		postFixExpression += operatorStack.pop();
	}
	
	return postFixExpression;
} 	// end convertToPostfix
 	/** Algorithm evaluatePostfix(postfix) // Evaluates a postfix expression.
 	 * valueStack = a new empty stack
 	 * while (postfix has characters left to parse)
 	 * Get an item
 	 * if item is an operand
 	 * valueStack.push(item)
 	 * else // item is an operator: '+', '-', '*', or'/'
 	 * operand2 = valueStack.pop()
 	 * operand1 = valueStack.pop()
 	 * result = operand1 item opernad2
 	 * valueStack.push(result)
 	 * return valueStack.pop()
 	 */

 	public static double evaluatePostfix(String postfix) {
	// ADD YOUR CODE HERE
 		//double value = 1;
 		ArrayStack valueStack = new ArrayStack();
 		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
		
			if (isVariable(c)) {
				double num = valueOf(c);
				valueStack.push(num);
			}
			else {
				double operand2 = Double.parseDouble(valueStack.pop().toString());
				double operand1 = Double.parseDouble(valueStack.pop().toString());
						
				if (c == '+') {
					
					double value = (operand1 + operand2);
					valueStack.push(value);
				}
				else if (c == '-') {
					double value = (operand1 - operand2);
					valueStack.push(value);
				}
				else if (c == '*') {
					double value = (operand1 * operand2);
					valueStack.push(value);
				}
				else if (c == '/') {
					double value = (operand1 / operand2);
					valueStack.push(value);
				}	
			}
 		}
 		return (double) valueStack.pop();
 	} 	// end evaluatePostfix
 	/** Task: Determines the precedence of a given operator.
 	 * @param operator a character that is (, ), +, -, *, or /
 	 * @return an integer that indicates the precedence of operator:
 	 * 0 if ( or ), 1 if + or -, 2 if * or /, -1 if anything else
 	 */
 	private static int getPrecedence(char operator) {
	 	switch (operator) {
	 		case '(': case ')': return 0;
	 		case '+': case '-': return 1;
	 		case '*': case '/': return 2;
	 	} // end switch
	 	return -1;
 	} // end getPrecedence
 	private static boolean isVariable(char ch) {
		return (ch == 'a') || (ch == 'b') || (ch == 'c') || (ch == 'd');
	} // end isVariable

	private static double valueOf(char variable) {
		switch (variable) {
			case 'a': return 2.0;
			case 'b': return 3.0;
			case 'c': return 4.0;
			case 'd': return 5.0;
		} // end switch
		return 0;
	} // end valueOf

} // end Postfix