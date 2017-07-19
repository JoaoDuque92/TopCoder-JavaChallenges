package challenge.permutible;

import java.util.Arrays;

public class Permutible {

	
	public static void main(String[] args) {
		Permutible p = new Permutible();
		
		System.out.println(p.isPossible(100035));
	}
	
	
	public String isPossible(int n) {

		//We will multiply by 2 to 9 beacause if we multiply by 10 
		//or more the result will have at least one digit more
		//and consequently the result will be "Impossible"
		for (int i = 2; i < 10; i++) {
			if (hasTheSameDigits(n, n * i)){
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
