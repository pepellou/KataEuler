package katas.refactor.euler;

public class Euler {

	public String problem(int numProblem) {
		switch (numProblem) {
		case 1:
			return problem1();
		case 2:
			return problem2();
		default:
			break;
		}
		return null;
	}

	private String problem1() {
		// Add all the natural numbers below one thousand that are multiples of
		// 3 or 5.
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				sum += i;
		}
		return "" + sum;
	}

	private String problem2() {
		// By considering the terms in the Fibonacci sequence whose values do
		// not exceed four million, find the sum of the even-valued terms.
		int f1 = 1;
		int f2 = 1;
		int sum = 0;
		while (f2 <= 4000000) {
			if (f2 % 2 == 0)
				sum += f2;
			int temp = f2;
			f2 = f1 + f2;
			f1 = temp;
		}
		return "" + sum;
	}

}
