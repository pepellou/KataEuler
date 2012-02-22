package katas.refactor.euler;

public class Euler {

	public String solveProblem(int numProblem) {
		ProblemSolver solver = getSolverForProblem(numProblem);
		if (solver == null)
			return null;
		return solver.solve();
	}

	private ProblemSolver getSolverForProblem(int numProblem) {
		try {
			return ((ProblemSolver) Class.forName(
					"katas.refactor.euler.ProblemSolver" + numProblem)
					.newInstance());
		} catch (Exception e) {
			return null;
		}
	}

}
