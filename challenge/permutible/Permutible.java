package challenge.permutible;

import java.util.Arrays;

public class Permutible {

	public String isPossible(int n) {

		/* We only need to multiply by 2 to 9 beacause
		 * we know if we multiply by 10 or more,
		 * the result will have more digits than n
		 */
		for (int i = 2; i < 10; i++) {
			if (hasTheSameDigits(n, n * i)) {
				return "Possible";
			}
		}

		return "Impossible";
	}

	private boolean hasTheSameDigits(int a, int b) {
		String strA = String.valueOf(a);
		String strB = String.valueOf(b);

		char[] arrayA = strA.toCharArray();
		char[] arrayB = strB.toCharArray();

		if (arrayA.length != arrayB.length)
			return false;

		Arrays.sort(arrayA);
		Arrays.sort(arrayB);

		return Arrays.equals(arrayA, arrayB);
	}
}
