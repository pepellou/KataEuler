package katas.refactor.euler;

public class ProblemSolver1 extends ProblemSolver {

	@Override
	public String solve() {
		int naturals[] = new int[1000];
		for (int natural = 0; natural < 1000; natural++) {
			naturals[natural] = natural;
		}
		return "" + sumValuesVerifyingCondition(naturals, isMultipleOf3And5());
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

}
