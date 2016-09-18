package saperclient.Network.Interpreter;

import saperclient.Network.Client;
import saperclient.Network.Interpreter.Events.*;
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
        event.add( new RegisterEvent( client ) ).add( new RankingEvent( client ) ).add( new GetBoardEvent( client ) ).add( new LossEvent(client) ).add( new WinEvent(client));
    }
    
    //==========================================================================
    
    public void exec( final NetRequest command ) throws Exception {
        
        event.handle( command );
    }
}
