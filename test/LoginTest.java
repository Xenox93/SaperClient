import saperclient.Model.Account;

import org.junit.*;
import static org.junit.Assert.assertTrue;
import saperclient.Exceptions.BlankLoginDataException;
import saperclient.Exceptions.IncorrectLoginDataException;

/**
 * @author Damian
 */
public class LoginTest {
    
    @Test
    public void testBlankLoginData() {
        
        boolean result = false;
        
        Account account = new Account();
        
        assertTrue( result );
    }
    
    /*@Test
    public void testIncorrectLoginData() {
        
        boolean result = false;
        
        Account account = new Account();
        
        try {
            
             account.login( "a", "a" );
            
        } catch( BlankLoginDataException ex ) {
            result = false;
        } catch( IncorrectLoginDataException ex ) {
            result = true;
        }
        
        assertTrue( result );
    }
    
    @Test
    public void testCorrectLoginData() {
        
        boolean result = true;
        
        Account account = new Account();
        
        try {
            
             account.login( "abc", "abc" );
            
        } catch( BlankLoginDataException | IncorrectLoginDataException ex ) {
            result = false;
        }
        
        assertTrue( result );
    }*/
}
