
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Rabindra Raj Suwal
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String>passwordA;

	@Before
	public void setUp() throws Exception {
		passwordA=new ArrayList<String>();
		String [] passwords= {"Rabindra@123","1xyz@MNO21","as#45@","Pr@jwal26","a123","!!!Stop","capit@l1","GETL0W^","Samsung21"};
		passwordA.addAll(Arrays.asList(passwords));
		
	}

	@After
	public void tearDown() throws Exception {
		passwordA=null;
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Rabindra@123"));
			PasswordCheckerUtility.isValidPassword("abc3");
			assertTrue("No length exception",false);
		}
		catch(LengthException e) {
			assertTrue("Threw Length exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Aribalo#45"));
			PasswordCheckerUtility.isValidPassword("aribalo");
			assertTrue("Did not throw NoUpperAlpha exception",false);
		}
		catch(NoUpperAlphaException e) {
			assertTrue("Threw NoUpperAlpha exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("lonDon42"));
			PasswordCheckerUtility.isValidPassword("GIANT%4");
			assertTrue("Did not throw NoLowerApha exception",false);
		}
		catch(NoLowerAlphaException e) {
			assertTrue("Threw NoLowerAlpha exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertTrue(PasswordCheckerUtility.isWeakPassword("R@8!ndr@"));
			PasswordCheckerUtility.isWeakPassword("");
			}
			catch(WeakPasswordException c) {
			assertTrue("Threw weakPassword exception",true);
			}
			catch (Exception e) {
			assertTrue("Threw other exception",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Reignn@4"));
			PasswordCheckerUtility.isValidPassword("Reignnn@44");
			assertTrue("did not Throw InvalidSequence exception",false);
		}
		catch(InvalidSequenceException e) {
			assertTrue("Threw InvalidSequence exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("R48!ndr@"));
			PasswordCheckerUtility.isValidPassword("R@b!ndra");
			assertTrue("did not throw HasDigit exception",false);
		}
		catch(NoDigitException e) {
			assertTrue("Threw NoDigit exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			PasswordCheckerUtility.isValidPassword("R@8!ndr@5uw@l");
			assertTrue("did not throw an exception",true);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> invalids;
		invalids = PasswordCheckerUtility.getInvalidPasswords(passwordA);
		assertEquals(invalids.get(0), "as#45@ -> The password must contain at least one uppercase alphabetic character");
		assertEquals(invalids.get(1), "a123 -> The password must be at least 6 characters long");
		assertEquals(invalids.get(2), "!!!Stop -> The password must contain at least one digit");
		assertEquals(invalids.get(3), "capit@l1 -> The password must contain at least one uppercase alphabetic character");
		assertEquals(invalids.get(4), "GETL0W^ -> The password must contain at least one lower case alphabetic character"); 
		assertEquals(invalids.get(5), "Samsung21 -> The password must contain at least one special character"); 
	}
	
}