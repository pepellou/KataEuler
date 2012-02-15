package katas.refactor.euler;

import java.util.Vector;

public abstract class Incrementor {

	public abstract long increment(long current_value,
			Vector<Long> previous_values);

	public static Incrementor incrementBy(final int increment) {
		return new Incrementor() {
			@Override
			public long increment(long current_value,
					Vector<Long> previous_values) {
				return current_value + increment;
			}
		};
	}

	public static Incrementor sumLastTwoValuesOr(final int defaultValue) {
		return new Incrementor() {
			@Override
			public long increment(long current_value,
					Vector<Long> previous_values) {
				int size = previous_values.size();
				return (size == 1) ? defaultValue : previous_values
						.get(size - 1) + previous_values.get(size - 2);

			}
		};
	}

}
