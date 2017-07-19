package challenge.heights;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class RelativeHeights {

	public int countWays(int[] h) {
		int result = 0;

		if (h.length > 1 && h.length <= 50 && validHeights(h)) {
			return howManyDifferent(h).size();
		}
		
		if(!(h.length > 1 && h.length <= 50)){
			result = 0;
		}else if(!validHeights(h)){
			result = -1;
		}

		return result;
	}

	private boolean validHeights(int[] h) {
		boolean valid = true;

		for (int height : h) {
			if (height < 1 || height > 1000) {
				valid = false;
			}
		}

		return valid;
	}

	private ArrayList<int[]> howManyDifferent(int[] h) {
		ArrayList<int[]> different = new ArrayList<>();

		for (int i = 0; i < h.length; i++) {
			int[] option = giveOption(h, i);

			int[] relativeOptions = relativeHeights(option);
			different.add(relativeOptions);
		}

		sameArrays(different);

		return different;
	}

	private void sameArrays(ArrayList<int[]> lst) {
		ArrayList<Integer> posToRemove = new ArrayList<>();
		for (int i = 0; i < lst.size(); i++) {
			for (int j = i + 1; j < lst.size(); j++) {
				int count = 0;
				int[] c1 = lst.get(i);
				int[] c2 = lst.get(j);

				for (int k = 0; k < c1.length; k++) {
					if (c1[k] == c2[k]) {
						count++;
					}
				}
				if (count == c1.length) {
					posToRemove.add(j);
				}
			}
		}

		Set<Integer> notRepeated = new HashSet<>();
		notRepeated.addAll(posToRemove);
		posToRemove.clear();
		posToRemove.addAll(notRepeated);

		Collections.sort(posToRemove, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return (o1 < o2) ? 1 : -1;
			}
		});

		for (Integer i : posToRemove) {
			lst.remove(lst.get(i));
		}

	}

	private int[] giveOption(int[] relative, int skip) {
		ArrayList<Integer> sorted = new ArrayList<>();

		for (int i = 0; i < relative.length; i++) {
			sorted.add(relative[i]);
		}

		sorted.remove(sorted.get(skip));

		int[] option = new int[sorted.size()];

		for (int i = 0; i < option.length; i++) {
			option[i] = sorted.get(i);
		}

		return option;
	}

	private int[] relativeHeights(int[] h) {
		int[] relative = new int[h.length];
		int relativeNumber = h.length - 1;

		for (int j = 0; j < h.length; j++) {
			int smallestPosition = 0;
			int smallestValue = 1001;
			for (int i = 0; i < h.length; i++) {
				if (relative[i] == 0) {
					if (h[i] < smallestValue) {
						smallestValue = h[i];
						smallestPosition = i;
					}
				}
			}
			relative[smallestPosition] = relativeNumber;
			relativeNumber--;
		}

		return relative;
	}

}
