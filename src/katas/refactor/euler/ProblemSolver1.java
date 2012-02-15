package katas.refactor.euler;

public class ProblemSolver1 extends ProblemSolver {

	@Override
	public String solve() {
		// Add all the natural numbers below one thousand that are multiples of
		// 3 or 5.
		int sum = 0;
		for (int natural = 0; natural < 1000; natural++) {
			if (multipleOf(natural, 3) || multipleOf(natural, 5))
				sum += natural;
		}
		return "" + sum;
	}

}
