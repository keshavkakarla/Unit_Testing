package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
/*
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
}*/

//NEW WAY USING MOCKITO
@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {
	
	@InjectMocks
	private SomeBusinessImpl business;
	
	@Mock
	private SomeDataService dataServiceMock;

	@Test
	public void calculateSumUsingDataService_Basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		assertEquals(6,business.calculateSumUsingDataService());
	}
	
	
	@Test
	public void calculateSumUsingDataService_Empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0,business.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumUsingDataService_OneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {3});
		assertEquals(3,business.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSum_Empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		assertEquals(0,business.calculateSum(new int[] {}));
	}
	

}
