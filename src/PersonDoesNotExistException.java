package src;
/**
 * An exception thrown in the <CODE>PersonDataManager</CODE> class to indicate that 
 * there is already same person in the array.
 */
public class PersonDoesNotExistException extends Exception {
	/**
	 * Default constructor for an PersonDoesNotExistException which passes default value to the class.
    * @custom.Postcondition:
    *    The object is created and contains the default message.
    */
     public PersonDoesNotExistException() {
    	 super();
     }
}
