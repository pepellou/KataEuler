package katas.refactor.euler;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EulerTest {

	private static Euler euler;

	@BeforeClass
	public static void setUp() {
		euler = new Euler();
	}

	@Test
	public void solvesProblem1() throws Exception {
		assertEquals("233168", euler.solveProblem(1));
	}

	@Test
	public void solvesProblem2() throws Exception {
		assertEquals("4613732", euler.solveProblem(2));
	}

	@Test
	public void solvesProblem10() throws Exception {
		assertEquals("142913828922", euler.solveProblem(10));
	}

}
