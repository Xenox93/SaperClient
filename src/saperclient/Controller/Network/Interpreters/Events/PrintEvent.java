package saperclient.Controller.Network.Interpreters.Events;

import saperclient.Controller.Network.Client;
import saperclient.Controller.Network.Interpreter.Event;
import saperclient.Controller.Network.Request;

/**
 * @author Damian
 */
public class PrintEvent extends Event
{
    public PrintEvent( Client client )
    {
        super( client );
    }
    
    //==========================================================================
    
    @Override
    public void handle( Request command )
    {
        if( command.getService().equals( "login" ) )
            System.out.println( "login" );
        else
            forward( command );
    }
}
