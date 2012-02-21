package katas.refactor.euler;

import java.util.Vector;

public class ProblemSolver10 extends ProblemSolver {

	@Override
	public String solve() {
		return "" + sumValues(getPrimesUpTo(2000000), Condition.truth());
	}

	private Long[] getPrimesUpTo(int topValue) {
		Condition condition = Condition.lessThan(topValue);
		Incrementor incrementor = Incrementor.incrementBy(2);
		Vector<Long> primes = new Vector<Long>();
		Vector<Long> squares_of_primes = new Vector<Long>();
		primes.add(2l);
		squares_of_primes.add(4l);
		for (long natural = 3; condition.verifiedBy(natural); incrementor
				.increment(natural, primes)) {
			boolean is_prime = true;
			for (int pr = 0; pr < primes.size() && is_prime
					&& squares_of_primes.get(pr) <= natural; pr++) {
				long divisor = primes.get(pr);
				if (natural % divisor == 0)
					is_prime = false;
			}
			if (is_prime) {
				primes.add(natural);
				squares_of_primes.add(natural * natural);
			}
		}
		return primes.toArray(new Long[0]);
	}

	@Override
	public String descriptionOfProblem() {
		return "Find the sum of all the primes below two million.";
	}

}
