//package _solution;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class SortedDoubleLinkedList_STUDENT_Test {
	SortedDoubleLinkedList<String> sortedLinkedString;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	SortedDoubleLinkedList<Phone> sortedLinkedPhone;
	StringComparator comparator;
	DoubleComparator comparatorD;
	PhoneComparator comparatorPhone;
	
	public Phone a=new Phone("Apple", "iPhone12", 2020);
	public Phone b=new Phone("Samsung", "Galaxy S10", 2019);
	public Phone c=new Phone("OnePlus", "7T", 2018);
	public Phone d=new Phone("Motorola", "G7", 2019);
	public Phone e=new Phone("Google", "Pixel", 2019);
	public Phone f=new Phone("Xiaomi", "Redmi", 2018);
	//alphabetic order: e f a c b d
	
	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
		
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		
		comparatorPhone = new PhoneComparator();
		sortedLinkedPhone = new SortedDoubleLinkedList<Phone>(comparatorPhone);
		
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		comparatorD = null;
		comparatorPhone = null;
		sortedLinkedString = null;
		sortedLinkedDouble = null;
		sortedLinkedPhone = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedString.addToFront("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulNext() {
		sortedLinkedPhone.add(a);
		sortedLinkedPhone.add(b);
		sortedLinkedPhone.add(c);
		sortedLinkedPhone.add(d);
		ListIterator<Phone> iterator = sortedLinkedPhone.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(a, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testIteratorSuccessfulStringPrevious() {
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("Zebra", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Zebra", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulCarPrevious() {
		sortedLinkedPhone.add(e);
		sortedLinkedPhone.add(c);
		sortedLinkedPhone.add(b);
		sortedLinkedPhone.add(d);
		//ArrayList<Car> carList = sortedLinkedCar.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Phone> iterator = sortedLinkedPhone.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(e, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(b, iterator.previous());
		assertEquals(c, iterator.previous());
		assertEquals(d, iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulDoubleNext() {
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(6));
		sortedLinkedDouble.add(new Double(1));
		sortedLinkedDouble.add(new Double(2));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(1), iterator.next());
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(6), iterator.next());
		assertEquals(true, iterator.hasNext());	}
	
	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(10));
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(2));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(5), iterator.next());
		assertEquals(new Double(8), iterator.next());
		assertEquals(true, iterator.hasPrevious());
		//assertEquals(new Double(10), iterator.previous());
		assertEquals(new Double(8), iterator.previous());
		assertEquals(true, iterator.hasPrevious());
	}
	
	@Test
	public void testIteratorNoSuchElementException() {
		sortedLinkedPhone.add(e);
		sortedLinkedPhone.add(c);
		sortedLinkedPhone.add(b);
		sortedLinkedPhone.add(d);
		//ArrayList<Car> carList = sortedLinkedCar.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Phone> iterator = sortedLinkedPhone.iterator();
		
		assertEquals(true, iterator.hasNext());
		assertEquals(e, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(b, iterator.next());
		try{
			//no more elements in list
			iterator.next();
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
	public void testIteratorUnsupportedOperationExceptionString() {
		sortedLinkedPhone.add(e);
		sortedLinkedPhone.add(c);
		sortedLinkedPhone.add(b);
		sortedLinkedPhone.add(d);
		//ArrayList<Phone> carList = sortedLinkedPhone.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Phone> iterator = sortedLinkedPhone.iterator();
		
		try{
			//remove is not supported for the iterator
			iterator.remove();
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
	public void testAddPhone() {
		//alphabetic order: e f a c b d
		sortedLinkedPhone.add(a);
		sortedLinkedPhone.add(b);
		sortedLinkedPhone.add(c);
		assertEquals(a, sortedLinkedPhone.getFirst());
		assertEquals(b, sortedLinkedPhone.getLast());
		sortedLinkedPhone.add(d);
		sortedLinkedPhone.add(e);
		assertEquals(a, sortedLinkedPhone.getFirst());
		assertEquals(b, sortedLinkedPhone.getLast());
		//deletes Elephant from linked list
		assertEquals(b,sortedLinkedPhone.retrieveLastElement());
		assertEquals(c, sortedLinkedPhone.getLast());
	}

	@Test
	public void testRemoveFirstPhone() {
		//alphabetic order: e f a c b d
		sortedLinkedPhone.add(b);
		sortedLinkedPhone.add(c);
		assertEquals(c, sortedLinkedPhone.getFirst());
		assertEquals(b, sortedLinkedPhone.getLast());
		sortedLinkedPhone.add(a);
		assertEquals(a, sortedLinkedPhone.getFirst());
		// remove the first
		sortedLinkedPhone.remove(a, comparatorPhone);
		assertEquals(c, sortedLinkedPhone.getFirst());
	}
	
	@Test
	public void testRemoveEndPhone() {
		//alphabetic order: e f a c b d
		sortedLinkedPhone.add(b);
		sortedLinkedPhone.add(f);
		assertEquals(b, sortedLinkedPhone.getFirst());
		assertEquals(f, sortedLinkedPhone.getLast());
		sortedLinkedPhone.add(d);
		assertEquals(f, sortedLinkedPhone.getLast());
		//remove from the end of the list
		sortedLinkedPhone.remove(d, comparatorPhone);
		assertEquals(f, sortedLinkedPhone.getLast());
	}

	@Test
	public void testRemoveMiddlePhone() {
		//alphabetic order: e f a c b d
		sortedLinkedPhone.add(a);
		sortedLinkedPhone.add(b);
		assertEquals(a, sortedLinkedPhone.getFirst());
		assertEquals(b, sortedLinkedPhone.getLast());
		sortedLinkedPhone.add(f);
		assertEquals(a, sortedLinkedPhone.getFirst());
		assertEquals(f, sortedLinkedPhone.getLast());
		assertEquals(3,sortedLinkedPhone.getSize());
		//remove from middle of list
		sortedLinkedPhone.remove(a, comparatorPhone);
		assertEquals(b, sortedLinkedPhone.getFirst());
		assertEquals(f, sortedLinkedPhone.getLast());
		assertEquals(2,sortedLinkedPhone.getSize());
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
	
	private class PhoneComparator implements Comparator<Phone>
	{

		@Override
		public int compare(Phone arg0, Phone arg1) {
			// Just put cars in alphabetic order by make
			return arg0.getMake().compareTo(arg1.getMake());
		}		
	}
	
	private class Phone{
		String make;
		String model;
		int year;
		
		public Phone(String make, String model, int year){
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