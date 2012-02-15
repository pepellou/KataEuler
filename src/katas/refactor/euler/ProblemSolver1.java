package katas.refactor.euler;

public class ProblemSolver1 extends ProblemSolver {

	@Override
	public String solve() {
		int sum = 0;
		int naturals[] = new int[1000];
		for (int natural = 0; natural < 1000; natural++) {
			naturals[natural] = natural;
		}
		for (int natural : naturals) {
			if (multipleOf(natural, 3) || multipleOf(natural, 5))
				sum += natural;
		}
		return "" + sum;
	}

	@Override
	public String descriptionOfProblem() {
		return "Add all the natural numbers below one thousand that are multiples of 3 or 5.";
	}

}
