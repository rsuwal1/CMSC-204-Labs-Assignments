//package _solution;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BasicDoubleLinkedList_STUDENT_Test {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	BasicDoubleLinkedList<Phones> linkedPhones;
	StringComparator comparator;
	DoubleComparator comparatorD;
	PhoneComparator comparatorPhone;
	
	public Phones a=new Phones("Apple", "iPhone12", 2020);
	public Phones b=new Phones("Samsung", "Galaxy S10", 2019);
	public Phones c=new Phones("OnePlus", "7T", 2018);
	public Phones d=new Phones("Motorola", "G7", 2019);
	public Phones e=new Phones("Google", "Pixel", 2019);

	public ArrayList<Phones> fill = new ArrayList<Phones>();
	

	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Buy");
		linkedString.addToEnd("Phone");
		comparator = new StringComparator();
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(181.0);
		linkedDouble.addToEnd(1030.0);
		comparatorD = new DoubleComparator();
		
		linkedPhones= new BasicDoubleLinkedList<Phones>();
		linkedPhones.addToEnd(d);
		linkedPhones.addToEnd(a);
		comparatorPhone = new PhoneComparator();
	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		linkedDouble = null;
		linkedPhones = null;
		comparatorD = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedString.getSize());
		assertEquals(2,linkedDouble.getSize());
		assertEquals(2,linkedPhones.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("Phone", linkedString.getLast());
		linkedString.addToEnd("End");
		assertEquals("End", linkedString.getLast());
		
		assertEquals(a,linkedPhones.getLast());
		linkedPhones.addToEnd(d);
		assertEquals(d,linkedPhones.getLast());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("Buy", linkedString.getFirst());
		linkedString.addToFront("Begin");
		assertEquals("Begin", linkedString.getFirst());
		
		assertEquals(d,linkedPhones.getFirst());
		linkedPhones.addToFront(a);
		assertEquals(a,linkedPhones.getFirst());
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("Buy", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		
		assertEquals(d,linkedPhones.getFirst());
		linkedPhones.addToFront(a);
		assertEquals(a,linkedPhones.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals("Phone", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		
		assertEquals(a,linkedPhones.getLast());
		linkedPhones.addToEnd(d);
		assertEquals(d,linkedPhones.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<Phones> list;
		linkedPhones.addToFront(a);
		linkedPhones.addToEnd(d);
		list = linkedPhones.toArrayList();
		assertEquals(a,list.get(0));
		assertEquals(d,list.get(1));
		assertEquals(a,list.get(2));
		assertEquals(d,list.get(3));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Buy", iterator.next());
		assertEquals("Phone", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
		
		linkedPhones.addToFront(a);
		linkedPhones.addToEnd(d);
		ListIterator<Phones> iteratorPhone = linkedPhones.iterator();
		assertEquals(true, iteratorPhone.hasNext());
		assertEquals(a, iteratorPhone.next());
		assertEquals(d, iteratorPhone.next());
		assertEquals(a, iteratorPhone.next());
		assertEquals(true, iteratorPhone.hasNext());
		assertEquals(d, iteratorPhone.next());
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedPhones.addToFront(a);
		linkedPhones.addToEnd(d);
		ListIterator<Phones> iteratorPhone = linkedPhones.iterator();
		assertEquals(true, iteratorPhone.hasNext());
		assertEquals(a, iteratorPhone.next());
		assertEquals(d, iteratorPhone.next());
		assertEquals(a, iteratorPhone.next());
		assertEquals(d, iteratorPhone.next());
		assertEquals(true, iteratorPhone.hasPrevious());
		assertEquals(d, iteratorPhone.previous());
		assertEquals(a, iteratorPhone.previous());
		assertEquals(d, iteratorPhone.previous());
		assertEquals(a, iteratorPhone.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedPhones.addToFront(a);
		linkedPhones.addToEnd(d);
		ListIterator<Phones> iteratorPhone = linkedPhones.iterator();		
		assertEquals(true, iteratorPhone.hasNext());
		assertEquals(a, iteratorPhone.next());
		assertEquals(d, iteratorPhone.next());
		assertEquals(a, iteratorPhone.next());
		assertEquals(true, iteratorPhone.hasNext());
		assertEquals(d, iteratorPhone.next());
		
		try{
			//no more elements in list
			iteratorPhone.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedPhones.addToFront(a);
		linkedPhones.addToEnd(d);
		ListIterator<Phones> iteratorPhone = linkedPhones.iterator();		
		assertEquals(true, iteratorPhone.hasNext());
		assertEquals(a, iteratorPhone.next());
		assertEquals(d, iteratorPhone.next());
		assertEquals(a, iteratorPhone.next());
		assertEquals(d, iteratorPhone.next());
		assertEquals(true, iteratorPhone.hasPrevious());
		assertEquals(d, iteratorPhone.previous());
		assertEquals(a, iteratorPhone.previous());
		assertEquals(d, iteratorPhone.previous());
		assertEquals(a, iteratorPhone.previous());
		
		try{
			//no more elements in list
			iteratorPhone.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		linkedPhones.addToFront(a);
		linkedPhones.addToEnd(d);
		ListIterator<Phones> iteratorPhone = linkedPhones.iterator();		
		assertEquals(true, iteratorPhone.hasNext());
		assertEquals(a, iteratorPhone.next());
		assertEquals(d, iteratorPhone.next());
		assertEquals(a, iteratorPhone.next());
		assertEquals(true, iteratorPhone.hasNext());
		assertEquals(d, iteratorPhone.next());
		
		try{
			//remove is not supported for the iterator
			iteratorPhone.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}
	
	@Test
	public void testRemove() {
		// remove the first
		assertEquals(d, linkedPhones.getFirst());
		assertEquals(a, linkedPhones.getLast());
		linkedPhones.addToFront(a);
		assertEquals(a, linkedPhones.getFirst());
		linkedPhones.remove(a, comparatorPhone);
		assertEquals(d, linkedPhones.getFirst());
		//remove from the end of the list
		linkedPhones.addToEnd(d);
		assertEquals(d, linkedPhones.getLast());
		linkedPhones.remove(d, comparatorPhone);
		assertEquals(d, linkedPhones.getLast());
		//remove from middle of list
		linkedPhones.addToFront(a);
		assertEquals(a, linkedPhones.getFirst());
		assertEquals(d, linkedPhones.getLast());
		linkedPhones.remove(b, comparatorPhone);
		assertEquals(a, linkedPhones.getFirst());
		assertEquals(d, linkedPhones.getLast());
		
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals(d, linkedPhones.getFirst());
		linkedPhones.addToFront(a);
		assertEquals(a, linkedPhones.getFirst());
		assertEquals(a, linkedPhones.retrieveFirstElement());
		assertEquals(d,linkedPhones.getFirst());
		assertEquals(d, linkedPhones.retrieveFirstElement());
		assertEquals(a,linkedPhones.getFirst());
		
		assertEquals("Buy", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		assertEquals("New", linkedString.retrieveFirstElement());
		assertEquals("Buy",linkedString.getFirst());
		assertEquals("Buy", linkedString.retrieveFirstElement());
		assertEquals("Phone",linkedString.getFirst());
		
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals(a, linkedPhones.getLast());
		linkedPhones.addToEnd(d);
		assertEquals(d, linkedPhones.getLast());
		assertEquals(d, linkedPhones.retrieveLastElement());
		assertEquals(a,linkedPhones.getLast());
		
		assertEquals("Phone", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		assertEquals("New", linkedString.retrieveLastElement());
		assertEquals("Phone",linkedString.getLast());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class PhoneComparator implements Comparator<Phones>
	{

		@Override
		public int compare(Phones arg0, Phones arg1) {
			// Just put Phones in alphabetic order by make
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}
	
	private class Phones{
		String make;
		String model;
		int year;
		
		public Phones(String make, String model, int year){
			this.make = make;
			this.model = model;
			this.year = year;
		}
		
		public String getMake(){
			return make;
		}
		public String getModel(){
			return model;
		}
		public int getYear(){
			return year;
		}
		
		public String toString() {
			return (getMake()+" "+getModel()+" "+getYear());
		}
	}
}