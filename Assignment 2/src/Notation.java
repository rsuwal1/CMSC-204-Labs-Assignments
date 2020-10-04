public class Notation {

	
    public Notation() {
        
    } 
    
	/**
	 * Converts Infix to Postfix
	 * @param infix The expression to be converted
	 * @return The post fix as a string
	 * @throws InvalidNotationFormatException if infix is invalid
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {

		
		NotationQueue<Character> postfixQueue = new NotationQueue<>(infix.length());
		NotationStack<Character> postfixStack = new NotationStack<>(infix.length());
		char[] chArray = infix.toCharArray();

		try {
			for (char current : chArray) {
				if (current == ' ') {
					continue;
				}
				if (Character.isDigit(current)) {
					postfixQueue.enqueue(current);
					continue;
				}
				if (current == '(') {
					postfixStack.push(current);
				}
				if (current == '*' || current == '/' || current == '+' || current == '-') {
					if (!postfixQueue.isEmpty()) {
						char top = postfixStack.top();
						if (top == '*' || top == '/' || current == '-' && top == '-' || current == '-' && top == '+'
								|| current == '+' && top == '-' || current == '+' && top == '+') {
							postfixQueue.enqueue(postfixStack.pop());

						}
					}
					postfixStack.push(current);
					continue;
				}
				if (current == ')') {
					while (postfixStack.top() != '(') {
						postfixQueue.enqueue(postfixStack.pop());
						if (postfixStack.top() == null) {
							throw new InvalidNotationFormatException();
						}
					}
					postfixStack.pop();
				}

			}
		} catch (QueueOverflowException | StackOverflowException | StackUnderflowException ignore) {
			throw new InvalidNotationFormatException();
		}
		return postfixQueue.toString();

	}
	
	
	/**
	 * Converts postfix to infix
	 * @param postfix the expression to be converted
	 * @return infix as a string
	 * @throws InvalidNotationFormatException if postfix is invalid
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {

		NotationStack<String> infixStack = new NotationStack<>(postfix.length());

		try {
			for (int i = 0; i < postfix.length(); i++) {
				char current = postfix.charAt(i);

				if (current == ' ') {
					continue;
				}
				if (Character.isDigit(current)) {
					infixStack.push(Character.toString(current));
					continue;
				}
				if (current == '*' || current == '/' || current == '+' || current == '-') {
					if (infixStack.size() < 2) {
						throw new InvalidNotationFormatException();
					}
					String first = infixStack.pop();
					String second = infixStack.pop();
					String s = "(" + second + current + first + ")";
					infixStack.push(s);

				}
			}

		} catch (StackUnderflowException | StackOverflowException ignore) {
			throw new InvalidNotationFormatException();
		}
		if (infixStack.size() > 1) {
			throw new InvalidNotationFormatException();
		}
		return infixStack.toString();
	}
    
	
	
	/**
	 * Performs required calculations
	 * @param first the first string to be parsed for calculation
	 * @param second the second string to be parsed for calculation
	 * @param o Operator
	 * @return result after calculation
	 */
	private static double evaluation(String first, String second,char o) {
		double result=0,a,b;
		switch(o) {
		case '+':
			a=Double.parseDouble(first);
			b=Double.parseDouble(second);
			result=a+b;
			break;
		
		case '-':
			a=Double.parseDouble(first);
			b=Double.parseDouble(second);
			result=a-b;
			break;
		
		case '*':
			a=Double.parseDouble(first);
			b=Double.parseDouble(second);
			result=a*b;
			break;
		
		case '/':
			a=Double.parseDouble(first);
			b=Double.parseDouble(second);
			result=a/b;
			break;
		
		default:
			System.out.println("Unknown operator");
		}	
		return result;
	}
	
	
	/**
	 * Calculates postfix expressions
	 * @param postfixExpr expression to be calculated
	 * @return result of calculation
	 * @throws InvalidNotationFormatException if postfix is invalid
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		String a, b;
		double result=0;
		NotationStack<String> postfixStack=new NotationStack<String>(10);
		char[] chArray=postfixExpr.toCharArray();
		
		try {
			for(int i=0;i<chArray.length;i++) {
				if(chArray[i]==' ') {
					continue;
				}
				if(Character.isDigit(chArray[i])|| chArray[i]=='(') {
					postfixStack.push(String.valueOf(chArray[i]));
				}
				else {
					if(postfixStack.size()<2) {
						throw new InvalidNotationFormatException();
					}
					else {
						b=postfixStack.pop();
						a=postfixStack.pop();
						result=evaluation(a,b,chArray[i]);
						postfixStack.push(Double.toString(result));
						
					}
				}
			}
			if(postfixStack.size()>1) {
				throw new InvalidNotationFormatException();
			}
		}
		catch(StackOverflowException d) {
			d.printStackTrace();
		}
		catch(StackUnderflowException s) {
			s.printStackTrace();
		}
		
					
		return result;
	}
}