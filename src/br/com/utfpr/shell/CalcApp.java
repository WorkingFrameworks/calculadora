package br.com.utfpr.shell;

import br.com.utfpr.core.calculator.BasicCalculator;
import br.com.utfpr.core.evaluator.PostfixEvaluator;

public class CalcApp {

	/**
	 * @param args
	 * -exp	
	 * -S, --soma
	 * -s, --sub
	 * -M, --mult
	 * -m, --mod
	 * -d, --div
	 * -MC
	 * -MR
	 * -MS
	 * -M+
	 * -M-
	 * -Q, --quit, --bye
	 */
	public static void main(String[] args) {
		BasicCalculator calc = new BasicCalculator(new PostfixEvaluator());
		String exp = mountExpression(args);
		System.out.println(calc.calculate(exp));
	}

	private static String mountExpression(String[] args) {
		return null;
	}

}
