package saperclient.Network.Interpreter.Events;

import saperclient.Network.Client;
import saperclient.Network.Interpreter.Event;
import saperclient.Network.NetRequest;

/**
 *
 * @author Damian
 */
public class GetFieldsEvent extends Event {
    
    public GetFieldsEvent( Client client )
    {
        super( client );
    }
    
    //==========================================================================
    
    @Override
    public void handle( NetRequest command ) throws Exception
    {
        if( command.getHeader().equals( "check_board" ) ) {
            
            // Wypełnienie konkretnych pól tekstem
        }
        else
            forward( command );
    }
}