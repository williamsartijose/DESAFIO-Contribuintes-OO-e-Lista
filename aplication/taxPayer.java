package DESAFIOContribuintesOOeLista.aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import DESAFIOContribuintesOOeLista.entities.TaxPayer;

public class taxPayer {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();

		System.out.println("How many contributors are you going to type?");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Type the dice do " + (i + 1) + " or taxpayer: ");

			System.out.print("Annual income with salary: ");
			double salaryIncome = sc.nextDouble();

			System.out.print("Annual income with service provision: ");
			double servicesIncome = sc.nextDouble();

			System.out.print("Annual income with capital gain: ");
			double capitalIncome = sc.nextDouble();

			System.out.print("medical expenses: ");
			double healthSpending = sc.nextDouble();

			System.out.print("educational expenses: ");
			double educationSpending = sc.nextDouble();

			list.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending));
		}

		for (TaxPayer obj : list) {
			System.out.println();
			System.out.println("Summary of " + (list.indexOf(obj) + 1) + "the taxpayer:");
			System.out.printf("total gross tax: %.2f%n", obj.grossTax());
			System.out.printf("rebate: %.2f%n", obj.taxRebate());
			System.out.printf("tax due: %.2f%n", obj.netTax());
		}

		sc.close();
	}

}
