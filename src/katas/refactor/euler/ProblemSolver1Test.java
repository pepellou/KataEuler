package katas.refactor.euler;

import org.junit.BeforeClass;

public class ProblemSolver1Test extends ProblemSolverTest {

	@BeforeClass
	public static void setUp() {
		solver = new ProblemSolver1();
	}

	@Override
	protected String descriptionOfProblem() {
		return "Add all the natural numbers below one thousand that are multiples of 3 or 5.";
	}

}
