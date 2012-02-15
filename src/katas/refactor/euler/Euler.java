package katas.refactor.euler;

public class Euler {

	private static final String PROBLEM_SOLVER_BASE_CLASSNAME = "katas.refactor.euler.ProblemSolver";

	public String solveProblem(int numProblem) {
		ProblemSolver solver = getSolverForProblem(numProblem);
		return (solver == null) ? null : solver.solve();
	}

	private ProblemSolver getSolverForProblem(int numProblem) {
		try {
			String className = PROBLEM_SOLVER_BASE_CLASSNAME + numProblem;
			return ((ProblemSolver) Class.forName(className).newInstance());
		} catch (Exception e) {
			return null;
		}
	}

}
