package saperclient.Network.Interpreter.Events;

import saperclient.Model.Level;
import saperclient.Network.Client;
import saperclient.Network.Interpreter.Event;
import saperclient.Network.NetRequest;

import saperclient.View.Frames.Board.BoardFrame;

/**
 *
 * @author Damian
 */
public class GetBoardEvent extends Event {
    
    public GetBoardEvent( Client client )
    {
        super( client );
    }
    
    //==========================================================================
    
    @Override
    public void handle( NetRequest command ) throws Exception
    {
        if( command.getHeader().equals( "get_board" ) ) {
            
            BoardFrame.level = new Level( 0, 0, 0 );
        }
        else
            forward( command );
    }
}