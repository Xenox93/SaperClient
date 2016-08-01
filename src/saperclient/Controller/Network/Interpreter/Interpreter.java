package saperclient.Controller.Network.Interpreter;

import saperclient.Controller.Network.Request;

/**
 * @author Damian
 */
public abstract class Interpreter
{
    protected Event event;
    
    //==========================================================================
    
    public void exec( final Request command ) {
        
        event.handle( command );
    }
}
