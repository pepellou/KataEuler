package katas.refactor.euler;

public class Problem2 extends Problem {

	@Override
	public String solve() {
		// By considering the terms in the Fibonacci sequence whose values do
		// not exceed four million, find the sum of the even-valued terms.
		int current_fibonnaci = 1;
		int next_fibonnaci = 1;
		int sum = 0;
		while (next_fibonnaci <= 4000000) {
			if (multipleOf(next_fibonnaci, 2))
				sum += next_fibonnaci;
			int temp = next_fibonnaci;
			next_fibonnaci = current_fibonnaci + next_fibonnaci;
			current_fibonnaci = temp;
		}
		return "" + sum;
	}

}
