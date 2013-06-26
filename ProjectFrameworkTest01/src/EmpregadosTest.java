import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmpregadosTest {
	EmpregadosCalc empregadosCalc;

	@BeforeClass
	public static void initialize() {
		System.out.println("Inicialização");
	}

	@AfterClass
	public static void destroy() {
		System.out.println("Finalização");
	}

	@Before
	public void setUpTest() {
		empregadosCalc = new EmpregadosCalc();
	}

	@Test
	public void calculateYearlySalary() {
		int result = empregadosCalc.calculateYearlySalary(100);
		Assert.assertEquals(1200, result);
	}

	@Test
	public void calculateAppraisal() {
		int result = empregadosCalc.calculateAppraisal(100);
		Assert.assertEquals(500, result);

		result = empregadosCalc.calculateAppraisal(2000);
		Assert.assertEquals(1000, result);
	}
}
