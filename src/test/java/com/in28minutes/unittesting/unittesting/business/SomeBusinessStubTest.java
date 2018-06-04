package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Test;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

//NOT USED. OLD WAY. PREFER MOCKING
public class SomeBusinessStubTest {
	
	class SomeDataServiceStub implements SomeDataService{
		@Override
		public int[] retrieveAllData() {
			return new int[] {1,2,3};
		}	
	}
	
	class SomeDataServiceStub_Empty implements SomeDataService{
		@Override
		public int[] retrieveAllData() {
			return new int[] {};
		}	
	}

	@Test
	public void calculateSumUsingDataService_Basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actual = business.calculateSumUsingDataService();
		int expected = 6;
		assertEquals(expected,actual);
	}
	
	@Test
	public void calculateSumUsingDataService_Empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub_Empty());
		int actual = business.calculateSumUsingDataService();
		int expected = 0;
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
