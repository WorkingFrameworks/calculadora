package br.com.utfpr.core.parser;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.utfpr.core.operators.Division;
import br.com.utfpr.core.operators.Mod;
import br.com.utfpr.core.operators.Multiplication;
import br.com.utfpr.core.operators.Sub;
import br.com.utfpr.core.operators.Sum;
import br.com.utfpr.core.parser.PostfixParser;

public class PostfixParserTest {
	static PostfixParser parser;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		parser = new PostfixParser();
		
		parser.registerOperator(new Sum());
		parser.registerOperator(new Sub());
		parser.registerOperator(new Multiplication());
		parser.registerOperator(new Division());
		parser.registerOperator(new Mod());
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

	@Test
	public void testToString() {
		assertEquals("PostfixParser", parser.toString());
	}

	@Test
	public void testParse() {

		String input = "( 1 + 2 ) * ( 4 / 2 ) - ( 5 + 6 )";
		String[] tokens = parser.parse(input);
		
		StringBuffer actual = new StringBuffer();
		for (String token : tokens) {
			actual.append(token).append(" ");
		}
		actual.deleteCharAt(actual.length() - 1);
		String expected = "1 2 + 4 2 / * 5 6 + -";
		assertEquals(expected, actual.toString());
	}

	@Test
	public void testRegisterOperator() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegisterOperatorTable() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsOperator() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOperator() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOperators() {
		fail("Not yet implemented");
	}

}
