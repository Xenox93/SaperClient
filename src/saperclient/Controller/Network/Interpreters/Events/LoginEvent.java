package saperclient.Controller.Network.Interpreters.Events;

import saperclient.Controller.Network.Client;
import saperclient.Controller.Network.Interpreter.Event;
import saperclient.Controller.Network.NetRequest;
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
        if( command.getService().equals( "login" ) ) {
            
            Account account = (Account)( command.getContent() );
            account.checkError();
        }
        else
            forward( command );
    }
}
