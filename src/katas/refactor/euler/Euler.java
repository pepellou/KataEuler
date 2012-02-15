package katas.refactor.euler;

public class Euler {

	public String solveProblem(int numProblem) {
		try {
			return ((ProblemSolver) Class.forName(
					"katas.refactor.euler.ProblemSolver" + numProblem).newInstance())
					.solve();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
