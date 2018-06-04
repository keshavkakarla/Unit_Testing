package com.in28minutes.unittesting.unittesting.spike;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JSONAssertTest {

	private String actualResponse = "\r\n" + 
			"{\"id\":1,\"name\":\"Ball\",\"price\":10,\"qty\":100}";
	@Test
	public void jSONassert_True_ExactMatchExceptSpaces() throws JSONException {
		
		String expectedResponse = "\r\n" + 
				"{\"id\":1,\"name\":\"Ball\",\"price\":10,\"qty\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	
	}
	
	@Test
	public void jSONassert_False() throws JSONException {
		
		String expectedResponse = "\r\n" + 
				"{\"id\":1,\"name\":\"Ball\",\"price\":10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	
	}
	
	@Test
	public void jSONassert_WithoutEscapeCharavters() throws JSONException {
		
		String expectedResponse = "\r\n" + 
				"{id:1,name:Ball,price:10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	
	}

}
