package katas.refactor.euler;

public class Euler {

	public String solveProblem(int numProblem) {
		try {
			return ((Problem) Class.forName(
					"katas.refactor.euler.Problem" + numProblem).newInstance())
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
