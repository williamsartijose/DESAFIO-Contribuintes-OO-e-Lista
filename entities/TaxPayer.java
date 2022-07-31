package DESAFIOContribuintesOOeLista.entities;

public class TaxPayer {

	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;

	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {

		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}

	// Imposto sobre Salário

	public Double salaryTax() {
		Double salaryTax;
		if ((salaryIncome / 12) < 3000) {
			salaryTax = salaryIncome;
		} else if ((salaryIncome / 12) > 3000 && (salaryIncome / 12) < 5000) {
			salaryTax = (salaryIncome * 0.10);
		} else {
			salaryTax = (salaryIncome * 0.20);
		}
		return salaryTax;
	}

	// Imposto sobre Serviço
	public Double servicesTax() {
		Double servicesTax = 0.0;
		if (servicesIncome > 0) {
			servicesTax = servicesIncome * 0.15;
		}
		return servicesTax;
	}

	// Imposto sobre Capital
	public Double capitalTax() {
		Double capitalTax = 0.0;
		if (capitalIncome > 0) {
			capitalTax = capitalIncome * 0.2;
		}
		return capitalTax;
	}

	// Imposto bruto
	public Double grossTax() {
		Double grossTax = salaryTax() + servicesTax() + capitalTax();
		return grossTax;
	}

	// Abatimento
	public Double taxRebate() {
		Double gastosDedutiveis = healthSpending + educationSpending;
		Double maximoDedutivel = grossTax() * 0.30;
		Double taxRebate = 0.0;

		if (maximoDedutivel > gastosDedutiveis) {
			taxRebate = gastosDedutiveis;
		} else {
			taxRebate = maximoDedutivel;
		}
		return taxRebate;
	}

	// Imposto Líquido
	public Double netTax() {
		Double netTax = grossTax() - taxRebate();
		return netTax;
	}
}