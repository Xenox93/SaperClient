package saperclient.Network.Interpreter;

import saperclient.Network.Client;
import saperclient.Network.Interpreter.Events.LoginEvent;
import saperclient.Network.NetRequest;

/**
 * @author Damian
 */
public class Interpreter
{
    private Event event;
    
    //==========================================================================
    
    public Interpreter( Client client ) {
        
        event = new LoginEvent( client );
    }
    
    //==========================================================================
    
    public void exec( final NetRequest command ) throws Exception {
        
        event.handle( command );
    }
}
