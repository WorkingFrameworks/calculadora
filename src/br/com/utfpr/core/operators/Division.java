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
					"A divis�o deve ser aplicada apenas a dois operandos");
		return operands[0] / operands[1];
	}

<<<<<<< HEAD
	public static Logger getLogger() {
		return LOGGER;
	}

=======
>>>>>>> 9df623da9dcd6c1e343d67fd72e0287236b7603b
}
