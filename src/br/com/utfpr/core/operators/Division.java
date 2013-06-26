package br.com.utfpr.core.operators;

import java.util.logging.Logger;

public class Division extends Operator {

	private final static Logger LOGGER = Logger.getLogger(Division.class
			.getName());

	public Division() {
		super("Division", "/", Associativity.LEFT, 5);
	}

	@Override
	public Double eval(Double... operands) throws ArithmeticException {
		if (operands.length != 2)
			throw new ArithmeticException(
					"A divisão deve ser aplicada apenas a dois operandos");
		return operands[0] / operands[1];
	}

	public static Logger getLogger() {
		return LOGGER;
	}

}
