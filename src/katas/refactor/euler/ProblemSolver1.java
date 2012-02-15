package katas.refactor.euler;

public class ProblemSolver1 extends ProblemSolver {

	@Override
	public String solve() {
		return ""
				+ sumValuesVerifyingCondition(getFirstXNaturals(1000),
						isMultipleOf3And5());
	}

	private Condition isMultipleOf3And5() {
		return new Condition() {
			@Override
			public boolean verifiedBy(int number) {
				return multipleOf(number, 3) || multipleOf(number, 5);
			}
		};
	}

	@Override
	public String descriptionOfProblem() {
		return "Add all the natural numbers below one thousand that are multiples of 3 or 5.";
	}

	protected Integer[] getFirstXNaturals(final int x) {
		return getFirstNumbersVerifyingCondition(0, Incrementor.incrementBy(1),
				Condition.lessThan(x));
	}

}
