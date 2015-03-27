class Hex implements Converter {
	double number;
	boolean status = false;
	String string;

	public double stringToNumber(String s) {

		try {
			number = Long.parseLong(s, 16);
			status = true;
		} catch (NumberFormatException e) {
			status = false;
		}

		return number;

	}

	public String numberToString(double num) {

		try {
			string = Long.toHexString((long) num);
			status = true;
		} catch (NumberFormatException e) {
			status = false;
		}
		string = string.toUpperCase() + "(16)";
		return string;
	}

	public boolean getStatus() {

		return status;
	}
}