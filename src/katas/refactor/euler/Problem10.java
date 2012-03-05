package katas.refactor.euler;

public class Problem10 {
	private final static int tamanho = 148932;
	private final static int limite = 2000000;

	public static String resolver() {
		// Find the sum of all the primes below two million
		long[] primo = new long[tamanho];
		long[] primo_cuadrado = new long[tamanho];
		int ultimoPrimo = 0;
		long sum = 2;
		for (long i = 3; i < limite; i += 2) {
			if (esPrimo(primo, primo_cuadrado, ultimoPrimo, i)) {
				primo[ultimoPrimo] = i;
				primo_cuadrado[ultimoPrimo++] = i * i;
				sum += i;
			}
		}
		return Long.toString(sum);
	}

	private static Long siguientePrimo(int pr, int ultimoPrimo, long[] primo,
			long[] primo_cuadrado, long i) {
		final boolean hayMasPrimos = pr < ultimoPrimo;
		final boolean nosInteresaEstePrimo = primo_cuadrado[pr] <= i;
		if (hayMasPrimos && nosInteresaEstePrimo)
			return primo[pr];
		else
			return null;
	}

	private static boolean esPrimo(final long[] primo,
			final long[] primo_cuadrado, final int ultimoPrimo, final long i) {

		class Iterador {
			private int pr = 0;

			public Long siguientePrimo() {
				try {
					if (pr < ultimoPrimo && primo_cuadrado[pr] <= i)
						return primo[pr];
					else
						return null;
				} finally {
					pr++;
				}
			}
		}

		Iterador it = new Iterador();
		Long siguientePrimo;
		while ((siguientePrimo = it.siguientePrimo()) != null) {
			if (EsMultiplo.de(i, siguientePrimo))
				return false;
		}

		return true;
	}
}
