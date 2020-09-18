import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * 
 * @author Rabindra Raj Suwal
 *
 */
public final class PasswordCheckerUtility {
	/**
	 * Compares two passwords
	 * @param password 1st password to be checked
	 * @param passwordConfirm 2nd password to be checked
	 * @throws UnmatchedException if passwords do not match
	 */
	public static void comparePasswords(java.lang.String password,
            java.lang.String passwordConfirm) throws UnmatchedException {
		if (!password.equals(passwordConfirm)) throw new UnmatchedException();
	}
	
	
	/**
	 * Compares two passwords
	 * @param password 1st password to be checked
	 * @param passwordConfirm 2nd password to be checked
	 * @return if passwords match
	 */
	public static boolean comparePasswordsWithReturn(java.lang.String password,
            java.lang.String passwordConfirm) {
		if (password.equals(passwordConfirm))
			return true;
		else
			return false;
	}
	
	

	/**
	 * Checks if the password is long enough to be valid
	 * @param pwd the password being checked
	 * @return true if password is at least 6 characters
	 * @throws LengthException if password is shorter than 6 characters
	 */
	public static boolean isValidLength(String pwd) throws LengthException
	{
		if (pwd.length()<6) 
			throw new LengthException();
		else
			return true;
	}

	
	/**
	 * Checks if the password has at least one upper case letter
	 * @param pwd the password being checked
	 * @return true if password has upper case letter
	 * @throws NoUpperAlphaException if password doesn't have upper case letter
	 */
	public static boolean hasUpperAlpha(String pwd) throws NoUpperAlphaException
	{
		if(pwd.equals(pwd.toLowerCase())) 
			throw new NoUpperAlphaException();
		else
			return true;		
	}
	
	
	/**
	 * Checks if the password has at least one lower case letter
	 * @param pwd the password being checked
	 * @return true if password has lower case letter
	 * @throws NoLowerAlphaException if password doesn't have lower case letter
	 */
	public static boolean hasLowerAlpha(String pwd) throws NoLowerAlphaException
	{

		if(pwd.equals(pwd.toUpperCase())) 
			throw new NoLowerAlphaException();
		else
			return true;
	}
	
	
	/**
	 * Checks if the password contains any digits
	 * @param pwd the password being checked
	 * @return true if the password contains a digit
	 * @throws NoDigitException if password doesn't contain a digit
	 */
	public static boolean hasDigit(String pwd) throws NoDigitException
	{
		boolean hasDigit = false;

		for (int i = 0 ; i < pwd.length() ; i++) {
			if (Character.isDigit(pwd.charAt(i)))
				hasDigit = true;
		}

		if (hasDigit==true)
			return hasDigit;
		else 
			throw new NoDigitException();
	}
	
	
	/**
	 * Checks if the password contains any special characters
	 * @param pwd the password being checked
	 * @return true is the password contains a special character
	 * @throws NoSpecialCharacterException if the password does't contain any special characters
	 */
	public static boolean hasSpecialChar(String pwd) throws NoSpecialCharacterException
	{
		String reg="[a-zA-Z0-9]*";
		Pattern pat=Pattern.compile(reg);
		Matcher mat=pat.matcher(pwd);
		
		if(mat.matches()) {
			throw new NoSpecialCharacterException();
		}
		else {
			return true;
		}
	}
	
	
	/**
	 * Checks if the password meets sequence requirements
	 * @param pwd the password being checked
	 * @return true if the password meets sequence requirements
	 * @throws InvalidSequenceException if the password doesn't meet sequence requirements
	 */
	public static boolean hasSameCharInSequence(String pwd) throws InvalidSequenceException
	{
		boolean isValid=true;
		for (int i=0;i<=pwd.length()-2;i++) { 
			if(pwd.charAt(i)==pwd.charAt(i+1)) {
				if (pwd.charAt(i)==pwd.charAt(i+2)) {
					isValid=false;
					throw new InvalidSequenceException();
				}
				
			}
		}
		return isValid;
	}
	
	
	/**
	 * Checks if the password is valid
	 * @param password the password being checked
	 * @return true if password is valid
	 * @throws LengthException password is too short
	 * @throws NoDigitException password has no digits
	 * @throws NoUpperAlphaException password has no upper case letters
	 * @throws NoLowerAlphaException password has no lower case letters
	 * @throws NoSpecialCharacterException password has no special characters
	 * @throws InvalidSequenceException password doesn't meet sequence requirements
	 */
	public static boolean isValidPassword(String password) throws LengthException,
	                                                                    NoDigitException,
                                                                        NoUpperAlphaException,
                                                                        NoLowerAlphaException,
                                                                        NoSpecialCharacterException,
                                                                        InvalidSequenceException 
	{
		if(isValidLength(password) == hasUpperAlpha(password) == hasLowerAlpha(password) == hasDigit(password) == hasSpecialChar(password) == hasSameCharInSequence(password) == true)
			return true;
		else
			return false;
	}
	
	
	/**
	 * checks if the password has 6 to 9 characters
	 * @param pwd the password being checked
	 * @return true if the password is 6 to 9 characters long
	 */
	public static boolean hasBetweenSixAndNineChars(String pwd)
	{
		boolean valid = false;
		if (pwd.length()>=6 && pwd.length()<=9) 
			valid = true;
		return valid;			
	}
	
	
	/**
	 * Checks if the password is weak.
	 * @param passwordString the password being checked
	 * @return true if the password is weak
	 * @throws WeakPasswordException 
	 */
	public static boolean isWeakPassword(String passwordString) throws WeakPasswordException{
		if(passwordString.length()>=6 && passwordString.length()<=9) {
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * Adds invalid passwords to array list
	 * @param passwords password array list of passwords
	 * @return array list of invalid password
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		ArrayList<String>pwd=new ArrayList<String>();
		String invld=null;
		for (int i=0;i<passwords.size();i++) {	
			try {
				invld=passwords.get(i);
				if(!isValidPassword(invld)) {
					invld=invld+"";
				}
			}
			catch(Exception e) {
				pwd.add(invld+" -> "+e.getMessage());
			}
		}
		
		return pwd;		
	}
	
	
	
	
}

