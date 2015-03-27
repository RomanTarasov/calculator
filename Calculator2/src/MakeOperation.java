
class MakeOperation implements Operation, Converter {
	Operation collector;
	Converter converter;
	boolean status = false;

	public double makeResult(int indexOfOperations, double firstOperand,
			double secondOperand) {

		switch (indexOfOperations) {
		case 0:
			collector = new Plus();
			break;
		case 1:
			collector = new Minus();
			break;
		default: {
			status = false;
			return 0;
		}
		}
		double result = collector.makeResultOfOperation(firstOperand,
				secondOperand);
		status = collector.getStatus();
		return result;
	}

	public String convertNumberToString(int indexOfOperations, double number) {
		switch (indexOfOperations) {
		case -2:
			converter = new Dec();
			break;
		case 0:
			converter = new Hex();
			break;
		case 1:
			converter = new Binary();
			break;
		case 2:
			converter = new Romana();
			break;
		default: {
			status = false;
			return null;
		}
		}
		String converted = converter.numberToString(number);
		status = converter.getStatus();
		return converted;

	}

	public double makeResultOfOperation(double firstOperand,
			double secondOperand) {
		status = false;
		return 0;
	}

	public boolean getStatus() {

		return status;
	}

	public String numberToString(double num) {
		status = false;
		return null;
	}

	public double stringToNumber(String s) {
		status = false;
		return 0;
	}

}
