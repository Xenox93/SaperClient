package saperclient.Network.Interpreter.Events;

import com.google.gson.Gson;
import saperclient.Model.Board;
import saperclient.Network.Client;
import saperclient.Network.Interpreter.Event;
import saperclient.Network.NetRequest;
import saperclient.View.Frames.Board.BoardFrame;

/**
 *
 * @author Damian
 */
public class GetFieldEvent extends Event {
    
    public GetFieldEvent( Client client )
    {
        super( client );
    }
    
    //==========================================================================
    
    @Override
    public void handle( NetRequest command ) throws Exception
    {
        if( command.getHeader().equals( "get_field" ) ) {
            
            BoardFrame.board = new Gson().fromJson( command.getData(), Board.class );
            BoardFrame.update();
        }
        else
            forward( command );
    }
}