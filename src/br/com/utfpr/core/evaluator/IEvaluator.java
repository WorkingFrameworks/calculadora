package br.com.utfpr.core.evaluator;

import java.util.Collection;

import br.com.utfpr.core.operators.Operator;

public interface IEvaluator {
	public double evaluate(String exp);

	public void registerOperators(Collection<Operator> opTable)
			throws Exception;

	public void registerOperator(Operator op) throws Exception;

	public Operator getOperator(String token);

	public boolean isOperator(String symbol);

}
