
class Binary implements Converter {
	double number;
	boolean status = false;
	String string;

	public double stringToNumber(String s) {

		try {
			number = Long.parseLong(s, 2);
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
		string = Integer.toBinaryString((int) num);

		status = true;
		string = string + "(2)";
		return string;
	}
}