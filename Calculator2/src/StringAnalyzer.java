class StringAnalyzer implements Operation {

	String[] modifiers = { "(16)", "(2)", "(r)" };
	Converter converter;

	int indexOfOperands;
	int indexOfOperators;
	int positionOfOperator = 0;
	int positionOfOperand = 0;
	int lengthOfOperator = 0;
	int lengthOfOperand = 0;
	double makeValue;
	String makeString;
	String stringBeforeModifier;
	boolean status = false;

	public boolean getStatus() {
		return status;
	}

	int makeOperand(String stringToAnalyze)

	{
		int maxLengthOfString = 80;
		int matchPoint = -1;
		if (stringToAnalyze.length() > maxLengthOfString) {
			stringToAnalyze = stringToAnalyze.substring(0, maxLengthOfString);
		}

		for (indexOfOperands = 0; indexOfOperands < modifiers.length; indexOfOperands++) {
			String s = modifiers[indexOfOperands];
			matchPoint = stringToAnalyze.indexOf(s);
			if (matchPoint != -1 && matchPoint > 0) {
				stringBeforeModifier = stringToAnalyze.substring(0, matchPoint);
				break;
			}
		}

		if (matchPoint > 0) {

			switch (indexOfOperands) {
			case 0:
				converter = new Hex();
				break;
			case 1:
				converter = new Binary();
				break;
			case 2:
				converter = new Romana();
				break;

			}

			makeValue = converter.stringToNumber(stringBeforeModifier);
			status = converter.getStatus();
			if (!status) {
				indexOfOperands = -1;
			}
			return indexOfOperands;
		}

		converter = new Dec();
		makeValue = converter.stringToNumber(stringToAnalyze);
		status = converter.getStatus();
		indexOfOperands = -2; // default transcoder is Dec

		if (!status) {
			indexOfOperands = -1;
		}
		return indexOfOperands;
	}

	int makeOperator(String stringToAnalyze) {
		int maxLengthOfString = 160;

		if (stringToAnalyze.length() > maxLengthOfString) {
			stringToAnalyze = stringToAnalyze.substring(0, maxLengthOfString);
		}

		for (indexOfOperators = 0; indexOfOperators < stringOperators.length; indexOfOperators++) {
			String s = stringOperators[indexOfOperators];
			lengthOfOperator = s.length();
			int matchPoint = stringToAnalyze.indexOf(s);
			if (matchPoint != -1) {
				positionOfOperator = matchPoint;
				return indexOfOperators;
			}

		}

		return -1;
	}

	public double makeResultOfOperation(double firstOperand,
			double secondOperand) {
		status = false;
		return 0;
	}

}