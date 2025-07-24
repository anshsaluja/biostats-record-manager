package src;
/**
 * An exception thrown in the <CODE>PersonDataManager</CODE> class to indicate that 
 * there is already same person in the array.
 */
public class PersonAlreadyExistException extends Exception {
	
	/**
	 * Default constructor for an PersonAlreadyExistException which passes default value to the class.
    * @custom.Postcondition:
    *    The object is created and contains the default message.
    */
	public PersonAlreadyExistException() {
		super();
	}

}
