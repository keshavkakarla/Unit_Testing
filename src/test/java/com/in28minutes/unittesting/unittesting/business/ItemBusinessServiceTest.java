package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import com.in28minutes.unittesting.unittesting.model.Item;

//NEW WAY USING MOCKITO
@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {
	
	@InjectMocks
	private ItemBusinessService business;
	
	@Mock
	private ItemRepository repository;

	@Test
	public void calculateSumUsingDataService_Basic() {
		when(repository.findAll()).thenReturn(Arrays.asList(
				new Item(1, "Ball", 10, 100), 
				new Item(3, "Ball3", 20, 100)));
		
		List<Item> items = business.retrieveAllItems();
		assertEquals(1000, items.get(0).getValue());
		assertEquals(2000, items.get(1).getValue());
	}
	
	
/*	@Test
	public void calculateSumUsingDataService_Empty() {
		when(repository.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0,business.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumUsingDataService_OneValue() {
		when(repository.retrieveAllData()).thenReturn(new int[] {3});
		assertEquals(3,business.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSum_Empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		assertEquals(0,business.calculateSum(new int[] {}));
	}
	*/

}
