package katas.refactor.euler;

public class Problem1 {
	
	private static final int limite = 1000;
	
	public static String resolver() {
		// Add all the natural numbers below one thousand that are multiples of
		// 3 or 5.
		int sum = 0;
		for (int i = 0; i < limite; i++) {
			if (EsMultiplo.de(i, 3) 
					|| EsMultiplo.de(i,5))
				sum += i;
		}
		return Integer.toString(sum);
	}
}
