interface Operation {

	String[] stringOperators = { "+", "-" };

	double makeResultOfOperation(double firstOperand, double secondOperand);

	boolean getStatus();

}
