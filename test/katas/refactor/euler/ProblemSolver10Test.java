package katas.refactor.euler;

import org.junit.BeforeClass;

public class ProblemSolver10Test extends ProblemSolverTest {

	@BeforeClass
	public static void setUp() {
		solver = new ProblemSolver10();
	}

	@Override
	protected String descriptionOfProblem() {
		return "Find the sum of all the primes below two million.";
	}

}
