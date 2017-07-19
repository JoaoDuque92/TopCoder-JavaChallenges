package challenge.replace;

public class LexmaxReplace {

	private int currPosition;
	private String currTString;
	private boolean changed;

	public LexmaxReplace() {
		this.currPosition = 0;
		this.changed = false;
	}

	public String get(String s, String t) {
		setCurrTString(t);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			System.out.println("i: " + i);
			char c = isThereAnyBigger(s.charAt(i));

			if (c != '0') {
				sb.append(c);
			} else {
				sb.append(s.charAt(i));
			}

		}

		return sb.toString();
	}

	private char isThereAnyBigger(char c) {
		char biggest = c;
		changed = false;
		for (int i = 0; i < currTString.length(); i++) {

			if (currTString.charAt(i) > biggest) {
				setCurrPosition(i);
				biggest = currTString.charAt(i);
				changed = true;
			}
		}

		if (changed) {
			deleteFromCurrTString(currPosition);
			return biggest;
		} else {
			return '0';
		}
	}

	private void deleteFromCurrTString(int pos) {
		String aux = "";
		System.out.println("DELETED " + currTString.charAt(pos));
		if (pos == 0) {
			aux += currTString.substring(1);
		} else if (pos == currTString.length() - 1) {
			aux += currTString.substring(0, currTString.length() - 1);
		} else {
			aux += currTString.substring(0, pos);
			aux += currTString.substring(pos + 1);
		}

		setCurrTString(aux);

	}

	public int getCurrPosition() {
		return currPosition;
	}

	public void setCurrPosition(int currPosition) {
		this.currPosition = currPosition;
	}

	public String getCurrTString() {
		return currTString;
	}

	public void setCurrTString(String currTString) {
		this.currTString = currTString;
	}

}
