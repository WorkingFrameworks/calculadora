package br.com.utfpr.core.operators;

public class Sub extends Operator {
	
	public Sub() {
		super("Subtraction", "-", Associativity.LEFT, 0);
	}

	@Override
	public Double eval(Double... operands) throws ArithmeticException {
		if (operands.length != 2)
			throw new ArithmeticException(
					"A subtração deve ser aplicada apenas a dois operandos");
		return operands[0] - operands[1];
	}
}
