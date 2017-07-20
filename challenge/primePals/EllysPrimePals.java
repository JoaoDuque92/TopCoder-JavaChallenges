package challenge.primePals;

public class EllysPrimePals {

	public String getKey(String[] strArray) {
		int length = strArray[0].length();

		int minNumber = getMinNumber(length);
		int maxNumber = getMaxNumber(length);

		if (length == 1) {
			minNumber = 0;
		}

		for (int i = minNumber; i <= maxNumber; i++) {
			for (int j = 0; j < strArray.length; j++) {

				String currNumber = strArray[j];
				String key = String.valueOf(i);

				if (!(isPrimeAndPalindromic(currNumber, key, length)))
					break;
				if (j == strArray.length - 1)
					return String.valueOf(i);
			}
		}

		return "No solution";
	}

	private boolean isPrimeAndPalindromic(String currNumber, String testKey, int length) {
		String tmpSolution = "";
		for (int k = 0; k < length; k++) {
			int digitCurrNumber = currNumber.charAt(k);
			int digitKey = testKey.charAt(k);

			int result = 0;
			if (digitKey > digitCurrNumber) {
				int aux = digitCurrNumber + 10;
				result = aux - digitKey;

			} else {
				result = digitCurrNumber - digitKey;
			}
			tmpSolution += result;
		}

		boolean isPalindromic = isPalindromic(Integer.valueOf(tmpSolution));
		boolean isPrime = isPrime(Integer.valueOf(tmpSolution));

		return isPalindromic && isPrime;
	}

	private int getMinNumber(int length) {
		return (int) Math.pow(10, length - 1);
	}

	private int getMaxNumber(int length) {

		int min = getMinNumber(length);

		String s = String.valueOf(min);
		String newStr = "";
		for (char c : s.toCharArray()) {
			newStr += '9';
		}

		return Integer.valueOf(newStr);
	}

	private boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	private boolean isPalindromic(int n) {
		StringBuilder sb = new StringBuilder();

		int previous = 0;
		for (int i = 10;; i *= 10) {
			int res = (n % i) - previous;
			previous += res;

			char appendChar = String.valueOf(res).charAt(0);
			sb.append(appendChar);

			if (i >= n) {
				break;
			}
		}

		int revNum = Integer.valueOf(sb.toString());

		if (n == revNum) {
			return true;
		}

		return false;
	}
}
