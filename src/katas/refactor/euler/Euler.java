package katas.refactor.euler;

import java.util.Vector;

public class Euler {

	public String problem(int numProblem) {
		switch (numProblem) {
		case 1:
			return problem1();
		case 2:
			return problem2();
		case 10:
			return problem10();
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

	private String problem10() {
		// Find the sum of all the primes below two million
		long[] p = new long[148932];
		long[] psq = new long[148932];
		int z = 0;
		long sum = 2;
		for (long i = 3; i < 2000000; i += 2) {
			boolean s = true;
			for (int pr = 0; pr < z && s && psq[pr] <= i; pr++) {
				long d = p[pr];
				if (i % d == 0)
					s = false;
			}
			if (s) {
				p[z] = i;
				psq[z++] = i * i;
				sum += i;
			}
		}
		return "" + sum;
	}

}
