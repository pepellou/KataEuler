package katas.refactor.euler;

public abstract class Condition {

	public abstract boolean verifiedBy(int number);

	public static Condition lessThan(final int x) {
		return new Condition() {
			@Override
			public boolean verifiedBy(int number) {
				return number < x;
			}
		};
	}

}
