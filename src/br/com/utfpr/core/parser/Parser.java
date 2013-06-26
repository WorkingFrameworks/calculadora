package br.com.utfpr.core.parser;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import br.com.utfpr.core.operators.Operator;

public abstract class Parser implements IParser {

	private Set<Operator> operators;
	private Set<String> symbols;

	public Parser() {
		operators = new HashSet<Operator>();
		symbols = new HashSet<String>();
	}

	public void registerOperator(Operator op) {
		operators.add(op);
		symbols.add(op.getSimbol());
	}

	public void registerOperatorTable(Collection<Operator> opTable) {
		for (Operator op : opTable)
			registerOperator(op);
	}

	public boolean isOperator(Operator op) {
		return operators.contains(op);
	}

	public boolean isOperator(String symbol) {
		return getOperator(symbol) != null;
	}
	
	public Operator getOperator(String token) {
		for (Operator op: operators)
			if (op.getSimbol().compareTo(token) == 0)
				return op;
		return null;
	}

	public String toString() {
		return "Parser";
	}

	public Set<Operator> getOperators() {
		return operators;
	}

	public Set<String> getSymbols() {
		return symbols;
	}

	

}
