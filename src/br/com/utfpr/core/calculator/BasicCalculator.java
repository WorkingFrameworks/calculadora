package br.com.utfpr.core.calculator;

import java.util.HashSet;
import java.util.Set;

import br.com.utfpr.core.evaluator.IEvaluator;
import br.com.utfpr.core.evaluator.PostfixEvaluator;
import br.com.utfpr.core.operators.Division;
import br.com.utfpr.core.operators.Mod;
import br.com.utfpr.core.operators.Multiplication;
import br.com.utfpr.core.operators.Operator;
import br.com.utfpr.core.operators.Sub;
import br.com.utfpr.core.operators.Sum;

public class BasicCalculator {

	// Always use the classname, this way you can refactor
//	private final static Logger LOGGER = Logger.getLogger(BasicCalculator.class
//			.getName());

	private IEvaluator evaluator;
	private double memory;
	private double buffer;

	public BasicCalculator(IEvaluator evaluator) {
//		LOGGER.info("Building calculator");
		buffer = 0.0;
		memory = 0.0;
		this.evaluator = evaluator;

		Set<Operator> operators = new HashSet<Operator>();
		operators.add(new Sum());
		operators.add(new Sub());
		operators.add(new Multiplication());
		operators.add(new Division());
		operators.add(new Mod());

		try {
			this.evaluator.registerOperators(operators);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public IEvaluator getEvaluator() {
		return evaluator;
	}

	public double getBuffer() {
		return buffer;
	}

	public void storeMemory(double value) {
		this.memory = value;
	}

	public void clearMemory() {
		this.memory = 0.0;
	}

	public void addMemory(double d) {
		this.memory += d;
	}

	public void subMemory(double d) {
		this.memory -= d;
	}

	public double recallMemory() {
		return this.memory;
	}

	public void reset() {
		buffer = 0.0;
		memory = 0.0;
	}

	public double calculate(String exp) {
		buffer = evaluator.evaluate(exp);
		return buffer;
	}

	public static void main(String args[]) {
		BasicCalculator calculator = new BasicCalculator(new PostfixEvaluator());

		System.out.println("( 2 + 5 ) * 6 = "
				+ calculator.calculate("( 2 + 5 ) * 6"));
	}

}
