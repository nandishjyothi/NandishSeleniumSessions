package myTests;

import org.testng.annotations.Test;

public class PriorityTest {

	/*
	 * Priority is assigning priority to test cases
	 * we can directly write @Test without any other annotations 
	 * to use priority we have to use 'priority' keyword next to @test annotation to assign the priority
	 * priority takes only integer
	 * 
	 * @Test(priority = 1)
	 * 
	 * can we have priority as 0? yes we can have priority as 0
	 * 
	 * can we have priority as negative number? yes we can have priority as negative
	 * number
	 * 
	 * what happens if 2 test are having same priority? if all the 5 tests are
	 * having priority and 2 of the tests having same priority(2,3,1,3,1) output: if
	 * 2 tests having same priority then those 2 tests will be executed based on
	 * alphabetical order o/p: c test(1) e test(1) a test(2) b test(3) d test(3)
	 * 
	 * what happens if few tests are not having priority? example 1: in 5 tests we
	 * are having priority for 3 tests(o,1,2) and 2 tests don have priority output:
	 * the 0th priority will be printed first and next without priority will be
	 * printed with alphabetical order and next the other priority will be executed
	 * o/p:o,NP,NP,1,2
	 * 
	 * example 2: in 5 tests we are having priority for 3 tests(1,2,3) and 2 tests
	 * don have priority output: no priority(NP) will be first executed in
	 * alphabetical order, then the tests having priority will be executed o/p:
	 * NP,NP,1,2,3
	 * 
	 * what happens if 3 tests having same priority and 2 tests are not having priority
	 * output: first non priority tests are executed alphabetical order and priority based tests are executed 
	 * based on the alphabetical order since they all having same priority 
	 * 
	 * 0 or below zero priority will be first executed if there are priority tests and non priority tests
	 * 
	 * 
	 */

	@Test(priority = 2)
	public void a_test() {
		System.out.println("a test");
	}

	@Test(priority = 3)
	public void b_test() {
		System.out.println("b test");
	}

	@Test(priority = -1)
	public void c_test() {
		System.out.println("c test");
	}

	@Test
	public void d_test() {
		System.out.println("d test");
	}

	@Test
	public void e_test() {
		System.out.println("e test");
	}

}
