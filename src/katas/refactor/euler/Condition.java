package katas.refactor.euler;

public abstract class Condition {

	public abstract boolean verifiedBy(int number);

	static boolean multipleOf(long natural, long divisor) {
		return natural % divisor == 0;
	}

	public static Condition lessThan(final int x) {
		return new Condition() {
			@Override
			public boolean verifiedBy(int number) {
				return number < x;
			}
		};
	}

	public static Condition isMultipleOf3Or5() {
		return or(isMultipleOf(3), isMultipleOf(5));
	}

	public static Condition isMultipleOf2() {
		return isMultipleOf(2);
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
				return multipleOf(number, divisor);
			}
		};
	}

}
