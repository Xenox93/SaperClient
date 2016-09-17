package saperclient.Network.Interpreter.Events;

import com.google.gson.Gson;

import saperclient.Model.Account;

import saperclient.Network.Client;
import saperclient.Network.Interpreter.Event;
import saperclient.Network.NetRequest;

/**
 *
 * @author Damian
 */
public class RegisterEvent extends Event
{
    public RegisterEvent( Client client )
    {
        super( client );
    }
    
    //==========================================================================
    
    @Override
    public void handle( NetRequest command ) throws Exception
    {
        if( command.getHeader().equals( "register" ) ) {
            
            Account account = new Gson().fromJson( command.getData(), Account.class );
            account.checkError();
        }
        else
            forward( command );
    }
}