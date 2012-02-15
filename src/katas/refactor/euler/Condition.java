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

	public static Condition or(final Condition condition1,
			final Condition condition2) {
		return new Condition() {
			@Override
			public boolean verifiedBy(int number) {
				return condition1.verifiedBy(number)
						|| condition2.verifiedBy(number);
			}
		};
	}

	public static Condition isMultipleOf(final int divisor) {
		return new Condition() {
			@Override
			public boolean verifiedBy(int number) {
				return number % divisor == 0;
			}
		};
	}

}
