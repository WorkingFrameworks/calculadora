import junit.framework.TestResult;
import junit.framework.TestSuite;

public class EmpregadosTestSuite {

	public static void main(String[] args) {
		TestSuite suite = new TestSuite(EmpregadosTest.class);
		TestResult result = new TestResult();

		suite.run(result);
		System.out.println("Numeros de teste :" + result.runCount());
	}
}
