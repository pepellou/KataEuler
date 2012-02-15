package katas.refactor.euler;

import java.util.Vector;

public abstract class ProblemSolver {

	public abstract String solve();

	public abstract String descriptionOfProblem();

	protected long sumValues(Long[] values, Condition conditionToVerify) {
		long sum = 0;
		for (Long value : values) {
			if (conditionToVerify.verifiedBy(value))
				sum += value;
		}
		return sum;
	}

	protected Long[] getFirstNumbers(int firstValue, Incrementor incrementor,
			Condition condition) {
		Vector<Long> numbers = new Vector<Long>();
		for (long number = firstValue; condition.verifiedBy(number); number = incrementor
				.increment(number, numbers)) {
			numbers.add(number);
		}
		return numbers.toArray(new Long[0]);
	}

}
