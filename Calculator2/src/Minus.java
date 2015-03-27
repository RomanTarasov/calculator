class Minus implements Operation {

	boolean status = false;

	public double makeResultOfOperation(double firstOperand,
			double secondOperand) {

		double result = firstOperand - secondOperand;
		status = true;
		return result;

	}

	public boolean getStatus() {

		return status;
	}

}
