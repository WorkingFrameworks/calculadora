package br.com.utfpr.core.parser;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.logging.Logger;

import br.com.utfpr.core.operators.Associativity;
import br.com.utfpr.core.operators.Division;
import br.com.utfpr.core.operators.Mod;
import br.com.utfpr.core.operators.Multiplication;
import br.com.utfpr.core.operators.Operator;
import br.com.utfpr.core.operators.Sub;
import br.com.utfpr.core.operators.Sum;
import br.com.utfpr.utils.Number;

public class PostfixParser extends Parser {

	private final static Logger LOGGER = Logger.getLogger(PostfixParser.class
			.getName());

	// Convert infix expression format into reverse Polish notation
	@Override
	public String[] parse(String input) {

		String[] inputTokens = input.split(" ");
		ArrayList<String> out = new ArrayList<String>();
		Deque<String> stack = new ArrayDeque<String>();

		// For each token
		for (String token : inputTokens) {
			// If token is an operator
			if (isOperator(token)) {
				// While stack not empty AND stack top element
				// is an operator
				while (!stack.isEmpty() && isOperator(stack.peek())) {
					Operator op1 = getOperator(token);
					Operator peek = getOperator(stack.peek());

					if ((op1.getAssociativity() == Associativity.LEFT)
							&& (op1.compareTo(peek) <= 0)
							|| (op1.getAssociativity() == Associativity.RIGHT)
							&& (op1.compareTo(peek) < 0)) {
						out.add(stack.pop());
						continue;
					}
					break;
				}
				// Push the new operator on the stack
				stack.push(token);
			}
			// If token is a left bracket '('
			else if (token.equals("(")) {
				stack.push(token); //
			}
			// If token is a right bracket ')'
			else if (token.equals(")")) {
				while (!stack.isEmpty() && !stack.peek().equals("(")) {
					out.add(stack.pop());
				}
				stack.pop();
			}
			// If token is a number
			else if (Number.isNumber(token)) {
				out.add(token);
			} else {
				throw new IllegalArgumentException("Invalid token: " + token);
			}
		}
		while (!stack.isEmpty()) {
			out.add(stack.pop());
		}
		String[] output = new String[out.size()];
		return out.toArray(output);
	}

	public String toString() {
		return "PostfixParser";
	}
	

	public static void main(String args[]) {
		PostfixParser parser = new PostfixParser();
		
		parser.registerOperator(new Sum());
		parser.registerOperator(new Sub());
		parser.registerOperator(new Multiplication());
		parser.registerOperator(new Division());
		parser.registerOperator(new Mod());

		String input = "( 1 + 2 ) * ( 4 / 2 ) - ( 5 + 6 )";
		// String input = "( 4 - 2 ) * 3 - 3 + 8 / 8 / ( 1 + 1 )";

		String[] tokens = parser.parse(input);
		StringBuffer actual = new StringBuffer();
		for (String token : tokens) {
			actual.append(token).append(" ");
		}
		actual.deleteCharAt(actual.length() - 1);
		System.out.print("#" + actual + "#");

	}

	public static Logger getLogger() {
		return LOGGER;
	}

	

}
