package katas.refactor.euler;

public class ProblemSolver2 extends ProblemSolver {

	@Override
	public String solve() {
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

	@Override
	public String descriptionOfProblem() {
		return "By considering the terms in the Fibonacci sequence "
				+ "whose values do not exceed four million, "
				+ "find the sum of the even-valued terms.";
	}

}
