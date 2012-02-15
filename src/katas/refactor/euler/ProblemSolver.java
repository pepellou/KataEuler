package katas.refactor.euler;

import java.util.Vector;

public abstract class ProblemSolver {

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

	protected Integer[] getFirstNumbersVerifyingCondition(int firstValue,
			Incrementor incrementor, Condition condition) {
		Vector<Integer> numbers = new Vector<Integer>();
		for (int number = firstValue; condition.verifiedBy(number); number = incrementor
				.increment(number, numbers)) {
			numbers.add(number);
		}
		return numbers.toArray(new Integer[0]);
	}

}
