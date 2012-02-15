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
		return getFirstNumbersMatchingCondition(0, new Incrementor() {
			@Override
			public int increment(int current_value,
					Vector<Integer> previous_values) {
				return current_value + 1;
			}
		}, new Condition() {
			@Override
			public boolean verifiedBy(int number) {
				return number < x;
			}
		});
	}

	private Integer[] getFirstNumbersMatchingCondition(int firstValue,
			Incrementor incrementor, Condition condition) {
		Vector<Integer> naturals = new Vector<Integer>();
		for (int natural = firstValue; condition.verifiedBy(natural); natural = incrementor
				.increment(natural, naturals)) {
			naturals.add(natural);
		}
		return naturals.toArray(new Integer[0]);
	}

	protected Integer[] getFibonacciNumbersUpTo(final int topValue) {
		return getFirstNumbersMatchingCondition(1, new Incrementor() {
			@Override
			public int increment(int current_value,
					Vector<Integer> previous_values) {
				int size = previous_values.size();
				return (size == 1) ? 1 : previous_values.get(size - 1)
						+ previous_values.get(size - 2);

			}
		}, new Condition() {
			@Override
			public boolean verifiedBy(int number) {
				return number <= topValue;
			}
		});
	}

}
