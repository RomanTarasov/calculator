class ModelOfCalculator {

	String numToString;

	String start(String task) {

		StringAnalyzer analyzer = new StringAnalyzer();
		MakeOperation makeOperation = new MakeOperation();

		int indexOfOperator = analyzer.makeOperator(task);
		int positionOfOperator = analyzer.positionOfOperator;
		int lengthOfOperator = analyzer.lengthOfOperator;
		if (indexOfOperator == -1) {
			return task + " error operator";
		}
		String fieldOfFirstOperand = task.substring(0, positionOfOperator);
		String fieldOfSecondOperand = task.substring(positionOfOperator
				+ lengthOfOperator);

		int indexOfFirstOperand = analyzer.makeOperand(fieldOfFirstOperand);
		if (indexOfFirstOperand == -1) {
			return task + " error first operand";
		}
		double valueOfFirstOperand = analyzer.makeValue;

		int indexOfSecondOperand = analyzer.makeOperand(fieldOfSecondOperand);
		if (indexOfSecondOperand == -1) {
			return task + " error second operand";
		}
		double valueOfSecondOperand = analyzer.makeValue;

		double resultOfTask = makeOperation.makeResult(indexOfOperator,
				valueOfFirstOperand, valueOfSecondOperand);
		boolean statusOfOperation = makeOperation.getStatus();
		if (!statusOfOperation) {
			return task + " error operation";
		}
		String resultOfTaskInStr = makeOperation.convertNumberToString(
				indexOfFirstOperand, resultOfTask);
		boolean statusOfConvertion = makeOperation.getStatus();
		if (!statusOfConvertion) {
			return task + " error result";
		}

		String resultOfCalculate = task + "=>" + resultOfTaskInStr;

		return resultOfCalculate;
	}

}
