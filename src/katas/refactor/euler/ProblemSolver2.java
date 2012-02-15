package katas.refactor.euler;

public class ProblemSolver2 extends ProblemSolver {

	@Override
	public String solve() {
		int topValue = 4000000;
		int[] fibonacci = fibonaccisUpTo(topValue);
		return "" + sumValuesVerifyingCondition(fibonacci, new Condition() {
			@Override
			public boolean verifiedBy(int number) {
				return multipleOf(number, 2);
			}
		});
	}

	private int[] fibonaccisUpTo(int topValue) {
		return firstXFibonaccis(34);
	}

	private int[] firstXFibonaccis(int x) {
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

	@Override
	public String descriptionOfProblem() {
		return "By considering the terms in the Fibonacci sequence "
				+ "whose values do not exceed four million, "
				+ "find the sum of the even-valued terms.";
	}

}
