package katas.refactor.euler;

public class ProblemSolver2 extends ProblemSolver {

	@Override
	public String solve() {
		return ""
				+ sumValuesVerifyingCondition(getFibonacciNumbersUpTo(4000000),
						new Condition() {
							@Override
							public boolean verifiedBy(int number) {
								return multipleOf(number, 2);
							}
						});
	}

	@Override
	public String descriptionOfProblem() {
		return "By considering the terms in the Fibonacci sequence "
				+ "whose values do not exceed four million, "
				+ "find the sum of the even-valued terms.";
	}

}
