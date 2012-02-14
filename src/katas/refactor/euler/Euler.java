package katas.refactor.euler;

import java.util.Vector;

public class Euler {

	public String problem1() {
		// Add all the natural numbers below one thousand that are multiples of
		// 3 or 5.
		int sum = 0;
		for (int natural = 0; natural < 1000; natural++) {
			if (natural % 3 == 0 || natural % 5 == 0)
				sum += natural;
		}
		return "" + sum;
	}

	public String problem2() {
		// By considering the terms in the Fibonacci sequence whose values do
		// not exceed four million, find the sum of the even-valued terms.
		int current_fibonnaci = 1;
		int next_fibonnaci = 1;
		int sum = 0;
		while (next_fibonnaci <= 4000000) {
			if (next_fibonnaci % 2 == 0)
				sum += next_fibonnaci;
			int temp = next_fibonnaci;
			next_fibonnaci = current_fibonnaci + next_fibonnaci;
			current_fibonnaci = temp;
		}
		return "" + sum;
	}

	public String problem10() {
		// Find the sum of all the primes below two million
		long[] primes = new long[148932];
		long[] squares_of_primes = new long[148932];
		int num_primes = 0;
		long sum = 2;
		for (long natural = 3; natural < 2000000; natural += 2) {
			boolean is_prime = true;
			for (int pr = 0; pr < num_primes && is_prime
					&& squares_of_primes[pr] <= natural; pr++) {
				long d = primes[pr];
				if (natural % d == 0)
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
