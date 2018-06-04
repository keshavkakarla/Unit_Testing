package com.in28minutes.unittesting.unittesting.controller;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.in28minutes.unittesting.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.unittesting.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class TestItemController {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;
	
	@Test
	public void helloWorld_basic() throws Exception {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		//call hello word and check the response 
		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:1,name:Ball,price:10,quantity:100}"))
				.andReturn();
		
		//assertEquals("Hello World", result.getResponse().getContentAsString());
		
	}
	
	
	@Test
	public void retrieveAllItemsTest_noMocking() throws Exception {
		
	}
	
	
	
	
	
	@Test
	public void retrieveAllItemsTest() throws Exception {
		
		when(businessService.retrieveAllItems()).thenReturn(
				Arrays.asList(
				new Item(1, "Ball", 10, 100), 
				new Item(3, "Ball3", 10, 100)));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/retrieve-all-items")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:1, name:Ball,price:10,quantity:100},"
						+ "{id:3, name:Ball3,price:10,quantity:100}]"))
				.andReturn();
		
	}
	
	
	@Test
	public void itemFromBusinessService_basic() throws Exception {
		
		when(businessService.returnHardCodedItem()).thenReturn(
				new Item(1, "Ball", 10, 100));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:1, name:Ball,price:10,quantity:100}"))
				.andReturn();
		
		//assertEquals("Hello World", result.getResponse().getContentAsString());
		
	}

	
}
