package katas.refactor.euler;

import org.junit.BeforeClass;

public class ProblemSolver2Test extends ProblemSolverTest {

	@BeforeClass
	public static void setUp() {
		solver = new ProblemSolver2();
	}

	@Override
	protected String descriptionOfProblem() {
		return "By considering the terms in the Fibonacci sequence "
		+ "whose values do not exceed four million, "
		+ "find the sum of the even-valued terms.";

	}

}
