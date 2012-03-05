package katas.refactor.euler;


public class Euler {
	
	public enum Problem {
		PROBLEM_1 {
			@Override
			public String resolver() {
				return Problem1.resolver();
			}
		}, PROBLEM_2 {
			@Override
			public String resolver() {
				return Problem2.resolver();
			}
		}, PROBLEM_10 {
			@Override
			public String resolver() {
				return Problem10.resolver();
			}
		};

		public abstract String resolver();
	}
}
