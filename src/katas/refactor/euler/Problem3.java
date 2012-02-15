package katas.refactor.euler;

public class Problem3 extends Problem {

	@Override
	public String solve() {
		// Find the sum of all the primes below two million
		long[] primes = new long[148932];
		long[] squares_of_primes = new long[148932];
		int num_primes = 0;
		long sum = 2;
		for (long natural = 3; natural < 2000000; natural += 2) {
			boolean is_prime = true;
			for (int pr = 0; pr < num_primes && is_prime
					&& squares_of_primes[pr] <= natural; pr++) {
				long divisor = primes[pr];
				if (multipleOf(natural, divisor))
					is_prime = false;
			}
			if (is_prime) {
				primes[num_primes] = natural;
				squares_of_primes[num_primes++] = natural * natural;
				sum += natural;
			}
		}
		return "" + sum;
	}

}
