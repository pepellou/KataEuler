package katas.refactor.euler;

public class ProblemSolver1 extends ProblemSolver {

	@Override
	public String solve() {
		int naturals[] = new int[1000];
		for (int natural = 0; natural < 1000; natural++) {
			naturals[natural] = natural;
		}
		return "" + sumValuesVerifyingCondition(naturals, new Condition() {
			@Override
			public boolean verifiedBy(int number) {
				return multipleOf(number, 3) || multipleOf(number, 5);
			}
		});
	}

	private int sumValuesVerifyingCondition(int[] values,
			Condition conditionToVerify) {
		int sum = 0;
		for (int value : values) {
			if (conditionToVerify.verifiedBy(value))
				sum += value;
		}
		return sum;
	}

	@Override
	public String descriptionOfProblem() {
		return "Add all the natural numbers below one thousand that are multiples of 3 or 5.";
	}

}
