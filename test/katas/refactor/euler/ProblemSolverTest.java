package katas.refactor.euler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public abstract class ProblemSolverTest {

	protected static ProblemSolver solver;

	protected abstract String descriptionOfProblem();

	@Test
	public void problemThatSolvesIsTheAdequate() throws Exception {
		assertEquals(descriptionOfProblem(), solver.descriptionOfProblem());
	}

}
