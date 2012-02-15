package katas.refactor.euler;

public class ProblemSolver2 extends ProblemSolver {

	@Override
	public String solve() {
		return ""
				+ sumValuesVerifyingCondition(getFibonacciNumbersUpTo(4000000),
						Condition.isMultipleOf(2));
	}

	@Override
	public String descriptionOfProblem() {
		return "By considering the terms in the Fibonacci sequence "
				+ "whose values do not exceed four million, "
				+ "find the sum of the even-valued terms.";
	}

	protected Integer[] getFibonacciNumbersUpTo(final int topValue) {
		return getFirstNumbersVerifyingCondition(1,
				Incrementor.sumLastTwoValuesOr(1), Condition.lessThan(topValue));
	}

}
