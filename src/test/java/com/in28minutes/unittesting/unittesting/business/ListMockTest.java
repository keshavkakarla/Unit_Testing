package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {
	
	List<String> mock = mock(List.class);

	@Test
	public void test() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void testDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void returnParameters() {
		when(mock.get(0)).thenReturn("in 28 minutes");
		assertEquals("in 28 minutes", mock.get(0));	
	}
	
	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("in 28 minutes");
		assertEquals("in 28 minutes", mock.get(0));
		assertEquals("in 28 minutes", mock.get(1));
	}
	
	@Test
	public void verifyBasics() {
		String value = mock.get(0);
		String value2 = mock.get(1);
		verify(mock).get(0);
		verify(mock,atLeast(1)).get(anyInt());
		verify(mock, times(2)).get(anyInt());
		verify(mock, never()).get(2);
	}
	
	@Test
	public void capturingArgument() {
		
		//SUT
		mock.add("someString1");
		mock.add("someString2");
		
		//VERIFY
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		assertEquals("someString1", allValues.get(0));
		assertEquals("someString2", allValues.get(1));
		
	}
	@Test
	public void mocking() {
		ArrayList<String> arrayListMock = mock(ArrayList.class);
		arrayListMock.get(0);
		arrayListMock.size();
		arrayListMock.add("one");
		arrayListMock.add("two");
		arrayListMock.size();
		when(arrayListMock.size()).thenReturn(5);
		arrayListMock.size();
		
	}
	
	@Test
	public void spying() {
		ArrayList<String> arrayListSpy = spy(ArrayList.class);
		System.out.println(arrayListSpy.size());
		System.out.println(arrayListSpy.add("one"));
		System.out.println(arrayListSpy.add("two"));
		System.out.println("size" + arrayListSpy.size());
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());
		
		verify(arrayListSpy).add("one");
		
	}

}
