package katas.refactor.euler;

import java.util.Vector;

public abstract class ProblemSolver {

	protected boolean multipleOf(long natural, long divisor) {
		return natural % divisor == 0;
	}

	public abstract String solve();

	public abstract String descriptionOfProblem();

	protected int sumValuesVerifyingCondition(Integer[] values,
			Condition conditionToVerify) {
		int sum = 0;
		for (int value : values) {
			if (conditionToVerify.verifiedBy(value))
				sum += value;
		}
		return sum;
	}

	protected Integer[] getFirstXNaturals(final int x) {
		return getFirstNumbersVerifyingCondition(0, Incrementor.incrementBy(1),
				Condition.lessThan(x));
	}

	protected Integer[] getFibonacciNumbersUpTo(final int topValue) {
		return getFirstNumbersVerifyingCondition(1,
				Incrementor.sumLastTwoValuesOr(1), Condition.lessThan(topValue));
	}

	private Integer[] getFirstNumbersVerifyingCondition(int firstValue,
			Incrementor incrementor, Condition condition) {
		Vector<Integer> naturals = new Vector<Integer>();
		for (int natural = firstValue; condition.verifiedBy(natural); natural = incrementor
				.increment(natural, naturals)) {
			naturals.add(natural);
		}
		return naturals.toArray(new Integer[0]);
	}

}
