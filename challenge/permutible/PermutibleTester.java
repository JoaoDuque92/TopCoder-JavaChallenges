package challenge.permutible;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PermutibleTester {

	private Permutible permutible;
	
	@Before
	public void init(){
		permutible = new Permutible();
	}
	
	@Test
	public void test1() {
		assertEquals("Possible", permutible.isPossible(142857));
	}
	
	@Test
	public void test2() {
		assertEquals("Impossible", permutible.isPossible(14));
	}
	
	@Test
	public void test3() {
		assertEquals("Possible", permutible.isPossible(1035));
	}
	
	@Test
	public void test4() {
		assertEquals("Impossible", permutible.isPossible(1000000));
	}
	
	@Test
	public void test5() {
		assertEquals("Possible", permutible.isPossible(100035));
	}
	
	@Test
	public void test6() {
		assertEquals("Impossible", permutible.isPossible(4));
	}

}
