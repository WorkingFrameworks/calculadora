/**
 * 
 */
package br.com.utfpr.core.operators;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;



/**
 * @author Jean
 * 
 */
public class DivisionTest {

	static Division div;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		div = new Division();
	}

	/**
	 * Test method for
	 * {@link br.edu.utfpr.metz.core.operators.Division#eval(Double...)}.
	 */
	@Test
	public void testEval() {
		assertEquals("Evaluation not precise enough", 2.0, div.eval(4.0, 2.0), 5);
	}

	/**
	 * Test method for
	 * {@link br.edu.utfpr.metz.core.operators.Operator#getName()}.
	 */
	@Test
	public void testGetName() {
		assertEquals("Division", div.getName());
	}

	/**
	 * Test method for
	 * {@link br.edu.utfpr.metz.core.operators.Operator#getSimbol()}.
	 */
	@Test
	public void testGetSimbol() {
		assertEquals("/", div.getSimbol());
	}

	/**
	 * Test method for
	 * {@link br.edu.utfpr.metz.core.operators.Operator#getAssociativity()}.
	 */
	@Test
	public void testGetAssociativity() {
		assertEquals(Associativity.LEFT, div.getAssociativity());
	}

	/**
	 * Test method for
	 * {@link br.edu.utfpr.metz.core.operators.Operator#getIntAssociativity()}.
	 */
	@Test
	public void testGetIntAssociativity() {
		assertEquals(0, div.getIntAssociativity());
	}

	/**
	 * Test method for
	 * {@link br.edu.utfpr.metz.core.operators.Operator#getPrecedence()}.
	 */
	@Test
	public void testGetPrecedence() {
		assertEquals(5, div.getPrecedence());
	}

	/**
	 * Test method for
	 * {@link br.edu.utfpr.metz.core.operators.Operator#toString()}.
	 */
	@Test
	public void testToString() {
		assertEquals(
				"Operator [name=Division, simbol=/, associativity=LEFT, precedence=5]",
				div.toString());
	}

	/**
	 * Test method for
	 * {@link br.edu.utfpr.metz.core.operators.Operator#compareTo(br.edu.utfpr.metz.core.operators.Operator)}
	 * .
	 */
	@Test
	public void testCompareTo() {
		Operator o = new Operator("newOp", "n", Associativity.LEFT, 3) {

			@Override
			public Double eval(Double... operands) throws ArithmeticException {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
		
		assertNotSame(o.getPrecedence(), div.getPrecedence());
		assertTrue(div.compareTo(o) > 0);
		
	}

}
