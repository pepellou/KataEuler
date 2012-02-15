package katas.refactor.euler;

public abstract class ProblemSolver {

	protected boolean multipleOf(long natural, long divisor) {
		return natural % divisor == 0;
	}

	public abstract String solve();

	public abstract String descriptionOfProblem();

	protected int sumValuesVerifyingCondition(int[] values,
			Condition conditionToVerify) {
		int sum = 0;
		for (int value : values) {
			if (conditionToVerify.verifiedBy(value))
				sum += value;
		}
		return sum;
	}

	protected int[] firstXNaturals(int x) {
		int naturals[] = new int[x];
		for (int natural = 0; natural < x; natural++) {
			naturals[natural] = natural;
		}
		return naturals;
	}

	protected int[] firstXFibonaccis(int x) {
		int[] fibonacci = new int[x];
		fibonacci[0] = 1;
		fibonacci[1] = 1;
		int current = 2;
		while (current < x) {
			fibonacci[current] = fibonacci[current - 1]
					+ fibonacci[current - 2];
			current++;
		}
		return fibonacci;
	}

}
