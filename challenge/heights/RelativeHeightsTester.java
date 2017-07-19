package challenge.heights;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RelativeHeightsTester {

	private RelativeHeights relativeHeights;
	
	@Before
	public void init(){
		relativeHeights = new RelativeHeights();
	}
	
	@Test
	public void test1() {
		int[] h = {1,3,6,10,15,21};
		
		assertEquals(1, relativeHeights.countWays(h));
	}
	
	@Test
	public void test2() {
		int[] h = {4,2,1,3};
		
		assertEquals(3, relativeHeights.countWays(h));
	}
	
	@Test
	public void test3() {
		int[] h = {6,2,352,43,5,44};
		
		assertEquals(6, relativeHeights.countWays(h));
	}
	
	@Test
	public void test4() {
		int[] h = {4,5,6,1,2,3};
		
		assertEquals(2, relativeHeights.countWays(h));
	}
	
	@Test
	public void test5() {
		int[] h = {10,9,7,5,3,1,8,6,4,2};
		
		assertEquals(9, relativeHeights.countWays(h));
	}
	
	@Test
	public void test6(){
		int[] h = {1,24, 634, 2, 56, 123546};
		
		assertTrue("Height out of range. Values allowed are between 1 and 1000", relativeHeights.countWays(h) == -1);
	}
	
	@Test
	public void test7(){
		int[] h = {1};
		
		assertTrue("Heights length not valid.", relativeHeights.countWays(h) == 0);
	}

}
