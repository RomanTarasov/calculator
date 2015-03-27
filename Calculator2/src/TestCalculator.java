import java.util.Scanner;

public class TestCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String resultOfCalculator;
		String task;
		double result;

		ModelOfCalculator model = new ModelOfCalculator();

		task = "123+345";
		resultOfCalculator = model.start(task);
		System.out.println(resultOfCalculator);

		task = "IV(r)+VI(r)";
		resultOfCalculator = model.start(task);
		System.out.println(resultOfCalculator);

		task = "1010(2)+101(2)";
		resultOfCalculator = model.start(task);
		System.out.println(resultOfCalculator);

		task = "AB34(16)+1234";
		resultOfCalculator = model.start(task);
		System.out.println(resultOfCalculator);

		task = "IV(r)+12";
		resultOfCalculator = model.start(task);
		System.out.println(resultOfCalculator);

		System.out.print("please input string: ");
		while (scanner.hasNext())

		{

			task = scanner.nextLine();
			resultOfCalculator = model.start(task);
			System.out.println(resultOfCalculator);
			System.out.print("please input string: ");

		}

	}
}
