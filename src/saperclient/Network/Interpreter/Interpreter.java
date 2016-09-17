package saperclient.Network.Interpreter;

import saperclient.Network.Client;
import saperclient.Network.Interpreter.Events.LoginEvent;
import saperclient.Network.Interpreter.Events.RankingEvent;
import saperclient.Network.Interpreter.Events.RegisterEvent;
import saperclient.Network.NetRequest;

/**
 * @author Damian
 */
public class Interpreter
{
    private final Event event;
    
    //==========================================================================
    
    public Interpreter( Client client ) {
        
        event = new LoginEvent( client );
        event.add( new RegisterEvent( client ) ).add( new RankingEvent( client ) );
    }
    
    //==========================================================================
    
    public void exec( final NetRequest command ) throws Exception {
        
        event.handle( command );
    }
}
