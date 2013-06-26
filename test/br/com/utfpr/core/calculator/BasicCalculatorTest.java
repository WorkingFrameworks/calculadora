package br.com.utfpr.core.calculator;

import static org.junit.Assert.*;

import org.junit.*;

import br.com.utfpr.core.evaluator.IEvaluator;
import br.com.utfpr.core.evaluator.PostfixEvaluator;

public class BasicCalculatorTest {
	private static BasicCalculator calc;
	private static IEvaluator evaluator;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		evaluator = new PostfixEvaluator();
		calc = new BasicCalculator(evaluator);
	}

	@Before
	public void setUp() throws Exception {
		calc.reset();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculator() {
		assertNotNull(calc);
	}

	@Test
	public void testMemory() {

		double recalled = calc.recallMemory();
		assertEquals("Expected 0.0, but a different value was retrieved", 0.0,
				recalled, 5);

		calc.storeMemory(5.0);
		recalled = calc.recallMemory();
		assertEquals("Expected 5.0, but a different value was retrieved", 5.0,
				recalled, 5);

		calc.clearMemory();
		recalled = calc.recallMemory();
		assertEquals("Expected 0.0, but a different value was retrieved", 0.0,
				recalled, 5);

		calc.addMemory(3.5);
		recalled = calc.recallMemory();
		assertEquals("Expected 3.5, but a different value was retrieved", 3.5,
				recalled, 5);

		calc.addMemory(1.5);
		recalled = calc.recallMemory();
		assertEquals("Expected 5.0, but a different value was retrieved", 5.0,
				recalled, 5);

		calc.subMemory(1.5);
		recalled = calc.recallMemory();
		assertEquals("Expected 3.5, but a different value was retrieved", 3.5,
				recalled, 5);
	}

	@Test
	public void testEvaluate() {
		assertTrue(calc.calculate("5 + 3") == 8);
		assertTrue(calc.calculate("5 + 3 * 2") == 11);

		String input = "( 1 + 2 ) * ( 4 / 2 ) - ( 5 + 6 )";
		double actual = calc.calculate(input);
		double expected = -5.0;
		assertEquals(
				"( 1 + 2 ) * ( 4 / 2 ) - ( 5 + 6 ) = -5.0",
				expected, actual, 5);

	}

	@Test
	public void testGetEvaluator() {
		assertEquals(evaluator, calc.getEvaluator());
	}

	@Test
	public void testCalculate() {
		
		String input = "( 2 + 5 ) * 6 = ";
		Double expected = 42.0;
		Double actual = calc.calculate(input);
		assertEquals("( 2 + 5 ) * 6 = 42.0", expected, actual, 5);
	}

}
