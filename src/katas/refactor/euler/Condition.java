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

	public static Condition isMultipleOf3And5() {
		return new Condition() {
			@Override
			public boolean verifiedBy(int number) {
				return multipleOf(number, 3) || multipleOf(number, 5);
			}
		};
	}

	public static Condition isMultipleOf2() {
		return isMultipleOf(2);
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
