/**
 * @author Joseph Cushmore
 * 
 * ClassID: 168
 * Assign1 
 * 
 * This file contains the testing for the SimpleList class.
 */
package cse360assign2;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import cse360assign2.SimpleList;


//----------Test add() -----------------
//--------------------------------------
class SimpleListTest 
{
	//Testing the adding of one element.
	@Test
	public void testCountAfterAdd()
	{
		//Setup
		SimpleList myList = new SimpleList();
		
		// Execution
		myList.add(2);
		
		// Check
		assertEquals(1,myList.count());
	}
	
	
	//Testing a full list with overflow.
	@Test
	public void testCountAfterAddToFullList()
	{
		//Setup
		SimpleList myList = new SimpleList();
		
		// Execution
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(4);
		myList.add(5);
		myList.add(6);
		myList.add(7);
		myList.add(8);
		myList.add(9);
		myList.add(10);
		myList.add(11);
		
		// Check
		assertEquals(10,myList.count());
	}
	
	
	//----------Test count() ---------------
	//--------------------------------------
	// Test the value of the count.
	@Test
	public void testCountAfterFive()
	{
		//Setup
		SimpleList myList = new SimpleList();
		
		// Execution
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(4);
		myList.add(5);
		
		//Check
		assertEquals(5,myList.count());
	}
	
	// Test the count with nothing in list.
	@Test
	public void testCountNoElements()
	{
		//Setup
		SimpleList myList = new SimpleList();
		
		// Execution
		
		//Check
		assertEquals(0,myList.count());
	}

	
	//----------Test remove() --------------
	//--------------------------------------
	// Call remove on no match check count.
	@Test
	public void removeNoMatch()
	{
		//Setup
		SimpleList myList1 = new SimpleList();
		
		// Execution
		myList1.add(2);
		myList1.add(4);
		myList1.add(8);
		
		myList1.remove(5);
		
		// Check
		assertEquals(3,myList1.count());
	}
	
	// Removing an integer and check count.
	@Test
	public void removeMatch()
	{
		//Setup
		SimpleList myList1 = new SimpleList();
		
		// Execution
		myList1.add(2);
		myList1.add(4);
		myList1.add(8);
		
		myList1.remove(4);
		
		// Check
		assertEquals(2,myList1.count());
	}
	
	// Remove the first element that matches the argument and check count.
	@Test
	public void removeTwoMatch()
	{
		//Setup
		SimpleList myList1 = new SimpleList();
		
		// Execution
		myList1.add(2);
		myList1.add(4);
		myList1.add(8);
		myList1.add(4);
		
		myList1.remove(4);
		
		// Check
		assertEquals(3,myList1.count());
	}
	
	
	//----------Test toString() ------------
	//--------------------------------------
	//Test the format of the toString.
	@Test
	public void testToString()
	{
		//Setup
		SimpleList myList1 = new SimpleList();
		
		// Execution
		myList1.add(1);
		myList1.add(2);
		myList1.add(3);
		myList1.add(4);
		
		// Check
		assertEquals("4 3 2 1",myList1.toString());
	}
	
	
	// Test a full string toString.
	@Test
	public void testToString2()
	{
		//Setup
		SimpleList myList1 = new SimpleList();
		
		// Execution
		myList1.add(1);
		myList1.add(2);
		myList1.add(3);
		myList1.add(4);
		myList1.add(5);
		myList1.add(6);
		myList1.add(7);
		myList1.add(8);
		myList1.add(9);
		myList1.add(10);
		myList1.add(11);
		myList1.add(12);
		
		// Check
		assertEquals("12 11 10 9 8 7 6 5 4 3",myList1.toString());
	}
	
	
	//----------Test search() -------------
	//--------------------------------------
	// Test the search with no match.
	@Test
	public void searchNoMatch()
	{
		//Setup
		SimpleList myList1 = new SimpleList();
		
		// Execution
		myList1.add(1);
		myList1.add(2);
		myList1.add(3);
		myList1.add(4);
		
		// Check
		assertEquals(-1, myList1.search(5));
	}
	// Search one matching value.
	@Test
	public void searchOneMatch()
	{
		//Setup
		SimpleList myList1 = new SimpleList();
		
		// Execution
		myList1.add(1);
		myList1.add(2);
		myList1.add(3);
		myList1.add(4);
		
		// Check
		assertEquals(0, myList1.search(4));
	}
	
	// Search noMatch out of bounds.
	@Test
	public void searchOutOfBounds()
	{
		//Setup
		SimpleList myList1 = new SimpleList();
		
		// Execution
		myList1.add(1);
		myList1.add(2);
		myList1.add(3);
		myList1.add(4);
		myList1.add(2);
		myList1.add(2);
		myList1.add(3);
		myList1.add(4);
		myList1.add(6);
		myList1.add(2);
		myList1.add(3);
		myList1.add(4);
		
		// Check
		assertEquals(-1, myList1.search(1));
	}
	
	
}
