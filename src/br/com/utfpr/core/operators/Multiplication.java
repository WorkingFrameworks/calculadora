package br.com.utfpr.core.operators;

import java.util.logging.Logger;

public class Multiplication extends Operator {

	private final static Logger LOGGER = Logger.getLogger(Multiplication.class
			.getName());

	public Multiplication() {
		super("Multiplication", "*", Associativity.LEFT, 5);
	}

	@Override
	public Double eval(Double... operands) throws ArithmeticException {
		if (operands.length != 2)
			throw new ArithmeticException(
					"A multiplicação deve ser aplicada apenas a dois operandos");
		return operands[0] * operands[1];
	}

}
