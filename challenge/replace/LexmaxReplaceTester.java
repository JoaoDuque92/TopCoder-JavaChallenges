package challenge.replace;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LexmaxReplaceTester {

	private LexmaxReplace replacer;
	
	@Before
	public void init(){
		replacer = new LexmaxReplace();
	}
	
	
	@Test
	public void test1() {
		String s = "xldyzmsrrwzwaofkcxwehgvtrsximxgdqrhjthkgfucrjdvwlr";
		String t = "xfpidmmilhdfzypbguentqcojivertdhshstkcysydgcwuwhlk";
		
		assertEquals("zyyyzyxwwwzwvuuttxwtssvtssxrqxppqrontmmllukrkjvwlr", replacer.get(s, t));
	}
	
	@Test
	public void test2() {
		String s = "top";
		String t = "coder";
		
		assertEquals("trp", replacer.get(s, t));
	}
	
	@Test
	public void test3() {
		String s = "fedcba";
		String t = "ee";
		
		assertEquals("feeeba", replacer.get(s, t));
	}
	
	@Test
	public void test4() {
		String s = "z";
		String t = "f";
		
		assertEquals("z", replacer.get(s, t));
	}

	@Test
	public void test5() {
		String s = "abb";
		String t = "c";
		
		assertEquals("cbb", replacer.get(s, t));
	}
}
