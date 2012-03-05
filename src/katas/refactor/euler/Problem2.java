package katas.refactor.euler;

public class Problem2 {
	private final static int limite = 4000000;
	
	public static class Fibonacci {
		private int f1, f2;
		public Fibonacci() {
			this.f1 = 1;
			this.f2 = 1;
		}
		
		public Fibonacci(int f1, int f2) {
			this.f1 = f1;
			this.f2 = f2;
		}

		public int next() {
			this.f2 = this.f1 + this.f2;
			this.f1 = this.f2 - this.f1;
			
			return this.f1;
		}

		public Fibonacci nextF() {
			return new Fibonacci(this.f2, this.f1 + this.f2);
		}

		public int getF1() {
			return f1;
		}

		public int getF2() {
			return f2;
		}
	}
	/**
	 * By considering the terms in the Fibonacci sequence whose values do
	 * not exceed four million, find the sum of the even-valued terms.
	 * 
	 * @return
	 */
	public static String resolver() {
		Fibonacci fib = new Fibonacci();
		
		int sum = 0;
		int value;
		while ((value = fib.next()) <= limite) {
			if (EsMultiplo.de(value, 2))
				sum += value;
		}
		
		return Integer.toString(sum);
	}
}
