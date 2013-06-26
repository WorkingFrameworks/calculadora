package br.com.utfpr.core.operators;


public class Mod extends Operator {

	public Mod() {
		super("Mod", "%", Associativity.LEFT, 5);
	}

	@Override
	public Double eval(Double... operands) throws ArithmeticException {
		if (operands.length != 2)
			throw new ArithmeticException(
					"A operação de resto deve ser aplicada apenas a dois operandos");
		return operands[0] % operands[1];
	}

}
