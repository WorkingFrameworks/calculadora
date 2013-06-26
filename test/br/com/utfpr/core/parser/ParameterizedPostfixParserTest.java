package br.com.utfpr.core.parser;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.com.utfpr.core.operators.Division;
import br.com.utfpr.core.operators.Mod;
import br.com.utfpr.core.operators.Multiplication;
import br.com.utfpr.core.operators.Sub;
import br.com.utfpr.core.operators.Sum;
import br.com.utfpr.core.parser.Parser;
import br.com.utfpr.core.parser.PostfixParser;

@RunWith(Parameterized.class)
public class ParameterizedPostfixParserTest {

	private String input;
	private String expected;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	public ParameterizedPostfixParserTest(String input, String expected) {
		this.input = input;
		this.expected = expected;
	}

	// Creates the test data
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
				{ "( ( ( 1 + 2 ) * 3 ) + 6 ) / ( 2 + 3 )", "1 2 + 3 * 6 + 2 3 + /" },
				{ "34 * 2 + 8 / 7", "34 2 * 8 7 / +" },
				{ "1 * ( 15 + 6 ) / 7", "1 15 6 + * 7 /" },
				{ "0 * ( 3 + 8 / 3 )", "0 3 8 3 / + *" },
				{ "( 4 + 2 * 5 ) / ( 1 + 3 * 2 )", "4 2 5 * + 1 3 2 * + /" },
				{ "( 2 * 5 + 4 ) / ( 3 * 2 + 1 )", "2 5 * 4 + 3 2 * 1 + /" },
				{ "( 1 + 2 ) * ( 4 / 2 ) - ( 5 + 6 )", "1 2 + 4 2 / * 5 6 + -" } };
		return Arrays.asList(data);
	}

	@Test
	public void testParse() {
		Parser parser = new PostfixParser();
		
		parser.registerOperator(new Sum());
		parser.registerOperator(new Sub());
		parser.registerOperator(new Multiplication());
		parser.registerOperator(new Division());
		parser.registerOperator(new Mod());
		
		String[] tokens = parser.parse(input);

		StringBuffer actual = new StringBuffer();
		for (String token : tokens) {
			actual.append(token).append(" ");
		}
		actual.deleteCharAt(actual.length() - 1);
		
		assertEquals(expected, actual.toString());
	}

}
