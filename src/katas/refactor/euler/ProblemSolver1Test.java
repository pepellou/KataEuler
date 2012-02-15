package katas.refactor.euler;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProblemSolver1Test {

	private static ProblemSolver1 solver;

	@BeforeClass
	public static void setUp() {
		solver = new ProblemSolver1();
	}

	@Test
	public void problemThatSolvesIsTheAdequate() throws Exception {
		assertEquals(
				"Add all the natural numbers below one thousand that are multiples of 3 or 5",
				solver.descriptionOfProblem());
	}
}
