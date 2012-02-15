package katas.refactor.euler;

public class Euler {

	private String solveProblem(int numProblem) {
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

	public String problem1() {
		return solveProblem(1);
	}

	public String problem2() {
		return solveProblem(2);
	}

	public String problem10() {
		return solveProblem(10);
	}

}
