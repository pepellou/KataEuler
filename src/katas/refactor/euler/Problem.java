package katas.refactor.euler;

public abstract class Problem {

	protected boolean multipleOf(long natural, long divisor) {
		return natural % divisor == 0;
	}

	public abstract String solve();

}
