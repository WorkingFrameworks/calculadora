public class EmpregadosCalc {

	public int calculateYearlySalary(int salMensal) {
		int result = salMensal * 12;
		return result;
	}

	public int calculateAppraisal(int salMensal) {
		int appraisal;
		int salAnual = this.calculateYearlySalary(salMensal);
		if (salAnual < 10000) {
			System.out.println("O appraisal � 500");
			appraisal = 500;
		} else {
			System.out.println("O appraisal � 1000");
			appraisal = 1000;
		}
		return appraisal;
	}
}
