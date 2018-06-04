package com.in28minutes.unittesting.unittesting.business;

import java.util.Arrays;
import java.util.OptionalInt;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {
	
	private SomeDataService someDataService;
	
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {
		
		OptionalInt number = Arrays.stream(data).reduce(Integer::sum);
		return number.orElse(0);		
	}
	
	public int calculateSumUsingDataService() {
		int[] data = someDataService.retrieveAllData();
		
		
		OptionalInt sum = Arrays.stream(data).reduce(Integer::sum);
		return sum.orElse(0);	
		
	}
	
	

}
