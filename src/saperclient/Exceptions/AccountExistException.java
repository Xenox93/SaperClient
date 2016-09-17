package saperclient.Exceptions;

/**
 *
 * @author Damian
 */
public class AccountExistException extends Exception {
    
    public AccountExistException() {
        
        super( "This account is exist !!!" );
    }
}
