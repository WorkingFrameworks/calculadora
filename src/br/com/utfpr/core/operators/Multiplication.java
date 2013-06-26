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
					"A multiplica��o deve ser aplicada apenas a dois operandos");
		return operands[0] * operands[1];
	}

<<<<<<< HEAD
	public static Logger getLogger() {
		return LOGGER;
	}

=======
>>>>>>> 9df623da9dcd6c1e343d67fd72e0287236b7603b
}
