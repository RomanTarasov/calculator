class Dec implements Converter {
	double number;
	boolean status = false;
	String string;

	public double stringToNumber(String s) {

		try {
			number = Integer.parseInt(s);
			status = true;
		} catch (NumberFormatException e) {

			status = false;
		}

		return number;
	}

	public boolean getStatus() {
		return status;
	}

	public String numberToString(double num) {
		status = false;
		string = String.valueOf(num);
		status = true;
		return string;
	}
}