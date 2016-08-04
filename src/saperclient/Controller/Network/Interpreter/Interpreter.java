package saperclient.Controller.Network.Interpreter;

import saperclient.Controller.Network.NetRequest;

/**
 * @author Damian
 */
public abstract class Interpreter
{
    protected Event event;
    
    //==========================================================================
    
    public void exec( final NetRequest command ) throws Exception {
        
        event.handle( command );
    }
}
