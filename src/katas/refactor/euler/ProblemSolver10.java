package katas.refactor.euler;

public class ProblemSolver10 extends ProblemSolver {

	@Override
	public String solve() {
		Long[] primes = new Long[148932];
		Long[] squares_of_primes = new Long[148932];
		int num_primes = 0;
		for (long natural = 3; natural < 2000000; natural += 2) {
			boolean is_prime = true;
			for (int pr = 0; pr < num_primes && is_prime
					&& squares_of_primes[pr] <= natural; pr++) {
				long divisor = primes[pr];
				if (natural % divisor == 0)
					is_prime = false;
			}
			if (is_prime) {
				primes[num_primes] = natural;
				squares_of_primes[num_primes++] = natural * natural;
			}
		}
		return "" + (sumValues(primes, Condition.truth()) + 2);
	}

	@Override
	public String descriptionOfProblem() {
		return "Find the sum of all the primes below two million.";
	}

}
