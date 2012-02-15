package katas.refactor.euler;

public class ProblemSolver1 extends ProblemSolver {

	@Override
	public String solve() {
		return ""
				+ sumValues(
						getFirstXNaturals(1000),
						Condition.or(Condition.isMultipleOf(3),
								Condition.isMultipleOf(5)));
	}

	@Override
	public String descriptionOfProblem() {
		return "Add all the natural numbers below one thousand that are multiples of 3 or 5.";
	}

	protected Long[] getFirstXNaturals(final int x) {
		return getFirstNumbers(0, Incrementor.incrementBy(1),
				Condition.lessThan(x));
	}

}
