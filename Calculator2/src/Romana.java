class Romana implements Converter {
	double number;
	boolean status = false;
	String string;

	public double stringToNumber(String stringToConvert) {

		String[] thousands = { "null", "M", "MM", "MMM" };
		String[] hundreds = { "null", "C", "CC", "CCC", "CD", "D", "DC", "DCC",
				"DCCC", "CM" };
		String[] tens = { "null", "X", "XX", "XXX", "XL", "L", "LX", "LXX",
				"LXXX", "XC" };
		String[] units = { "null", "I", "II", "III", "IV", "V", "VI", "VII",
				"VIII", "IX" };
		int section = 0;
		String sectionOfString = stringToConvert;
		int summa = 0;

		int max = 0;
		for (int index = 1; index < 4; index++) {
			String fromThousands = thousands[index];
			int match = stringToConvert.indexOf(fromThousands);
			if (match == 0) {
				max = index;
			}
		}
		summa = max * 1000;
		if (max > 0) {
			section += thousands[max].length();
			sectionOfString = stringToConvert.substring(section);
		}

		max = 0;

		for (int index = 1; index < 10; index++) {
			String fromHundreds = hundreds[index];
			int match = sectionOfString.indexOf(fromHundreds);
			if (match == 0) {
				max = index;
			}
		}
		summa += max * 100;
		if (max > 0) {
			section += hundreds[max].length();
			sectionOfString = stringToConvert.substring(section);
		}

		max = 0;

		for (int index = 1; index < 10; index++) {
			String fromTens = tens[index];
			int match = sectionOfString.indexOf(fromTens);
			if (match == 0) {
				max = index;
			}
		}
		summa += max * 10;
		if (max > 0) {
			section += tens[max].length();
			sectionOfString = stringToConvert.substring(section);
		}

		max = 0;

		for (int index = 1; index < 10; index++) {
			String fromUnits = units[index];
			int match = sectionOfString.indexOf(fromUnits);
			if (match == 0) {
				max = index;
			}
		}
		if (max > 0) {
			section += units[max].length();
		}
		if (section != stringToConvert.length()) {
			status = false;
			return 0;
		}

		summa += max;
		status = true;
		return summa;
	}

	public boolean getStatus() {
		return status;
	}

	public String numberToString(double number) {
		int[] numbers = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		if (number > 3999 || number == 0 || number < 0) {
			status = false;
			return string;
		}
		String string = "";
		int i = (int) number;

		for (int j = 0; j < 13; j++) {
			while (i >= numbers[j]) {
				string += symbols[j];
				i -= numbers[j];
			}
		}

		status = true;
		return string + "(r)";
	}
}