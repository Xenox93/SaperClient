package saperclient.Model;

import saperclient.Exceptions.*;

/**
 * @author Damian
 */
public class Account extends Error {
    
    private String login;
    private String password;
    
    //==========================================================================
    
    public Account() {
        
        this.error = "";
        this.login = "";
        this.password = "";
    }
    public Account( String login, String password ) {
        
        this.error = "";
        this.login = login;
        this.password = password;
    }
    public Account( Account account ) {
        
        login = account.getLogin();
        password = account.getPassword();
    }
    
    //--------------------------------------------------------------------------
    
    public void setLogin( String login ) {
        
        this.login = login;
    }
    public void setPassword( String password ) {
        
        this.password = password;
    }
    
    public final String getLogin() {
        return login;
    }
    public final String getPassword() {
        return password;
    }
    
    //==========================================================================

    /**
     *
     * @throws IncorrectLoginDataException
     * @throws saperclient.Exceptions.AccountExistException
     * @throws saperclient.Exceptions.AccountRegisterFailedException
     */
    @Override
    public void checkError() throws IncorrectLoginDataException, AccountExistException, AccountRegisterFailedException {
        
        if( !isError() )
            return;
        
        if( error.equals( "IncorrectLoginDataException" ) )
            throw new IncorrectLoginDataException();
        else if( error.equals( "AccountExistException" ) )
            throw new AccountExistException();
        else if( error.equals( "AccountRegisterFailedException" ) )
            throw new AccountRegisterFailedException();
    }
}
