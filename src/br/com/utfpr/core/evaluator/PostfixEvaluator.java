package br.com.utfpr.core.evaluator;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Set;

import br.com.utfpr.core.operators.Operator;
import br.com.utfpr.core.parser.PostfixParser;

public class PostfixEvaluator implements IEvaluator {
	private PostfixParser parser;
	private Set<Operator> operators;

	public PostfixEvaluator() {
		this.parser = new PostfixParser();
	}

	public double evaluate(String exp) {
		if (parser == null)
			throw new UnsupportedOperationException(
					"Parser must be set before evaluate an expression.");

		String[] tokens = parser.parse(exp);

		Deque<String> stack = new ArrayDeque<String>();
		for (String token : tokens) {
			// If the token is a value push it onto the stack
			if (!isOperator(token)) {
				stack.push(token);
			} else {
				// Token is an operator: pop top two entries
				Double d2 = Double.valueOf(stack.pop());
				Double d1 = Double.valueOf(stack.pop());
				// Get the result and push onto the stack
				stack.push(String.valueOf(getOperator(token).eval(d1, d2)));
			}
		}
		return Double.valueOf(stack.pop());
	}

	public void registerOperator(Operator op) throws Exception {
		operators.add(op);
		parser.registerOperator(op);
	}

	public void registerOperators(Collection<Operator> opTable)
			throws Exception {
		operators = (Set<Operator>) opTable;
		parser.registerOperatorTable(opTable);
	}

	public Operator getOperator(String token) {
		for (Operator op : operators)
			if (op.getSimbol().compareTo(token) == 0)
				return op;
		return null;
	}

	public boolean isOperator(String symbol) {
		return getOperator(symbol) != null;
	}
}
