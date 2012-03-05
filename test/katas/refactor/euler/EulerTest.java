package katas.refactor.euler;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EulerTest {

	@BeforeClass
	public static void setUp() {
//		euler = new Euler();
	}

	@Test
	public void solvesProblem1() throws Exception {
<<<<<<< HEAD
		assertEquals("233168", euler.problem(1));
=======
		assertEquals("233168", Euler.Problem.PROBLEM_1.resolver());
>>>>>>> 3cc6d37... Mar 2 2012 - Refactoring Randori Dojo - Lab38
	}

	@Test
	public void solvesProblem2() throws Exception {
		assertEquals("4613732", Euler.Problem.PROBLEM_2.resolver());
	}

	@Test
	public void solvesProblem10() throws Exception {
		assertEquals("142913828922", Euler.Problem.PROBLEM_10.resolver());
	}
	
}
