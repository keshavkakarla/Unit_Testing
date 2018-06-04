package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Test;

//SIMPLE TEST
public class SomeBusinessTest { 

	@Test
	public void calculateSum_Basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actual = business.calculateSum(new int[] {1,2,3});
		int expected = 6; 
		assertEquals(expected,actual); 
	}
	
	@Test
	public void calculateSum_Empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actual = business.calculateSum(new int[] {});
		int expected = 0;
		assertEquals(expected,actual);
	}

}
