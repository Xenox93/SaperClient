package saperclient.Network.Interpreter.Events;

import com.google.gson.Gson;
import saperclient.Network.Client;
import saperclient.Network.Interpreter.Event;
import saperclient.Network.NetRequest;

import saperclient.Model.Account;

/**
 * @author Damian
 */
public class LoginEvent extends Event
{
    public LoginEvent( Client client )
    {
        super( client );
    }
    
    //==========================================================================
    
    @Override
    public void handle( NetRequest command ) throws Exception
    {
        if( command.getHeader().equals( "login" ) ) {
            
            Account account = new Gson().fromJson( command.getData(), Account.class );
            account.checkError();
        }
        else
            forward( command );
    }
}
