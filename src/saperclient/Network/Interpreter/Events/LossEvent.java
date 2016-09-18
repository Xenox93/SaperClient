package saperclient.Network.Interpreter.Events;

import javax.swing.JDialog;
import saperclient.Network.Client;
import saperclient.Network.Interpreter.Event;
import saperclient.Network.NetRequest;
import saperclient.SaperClient;
import saperclient.View.Dialogs.MessageDialog;
import saperclient.View.Frames.Menu.MenuFrame;

/**
 *
 * @author Damian
 */
public class LossEvent extends Event
{
    public LossEvent( Client client )
    {
        super( client );
    }
    
    //==========================================================================
    
    @Override
    public void handle( NetRequest command ) throws Exception
    {
        if( command.getHeader().equals( "loss" ) ) {
            
            new MessageDialog( "You lost", SaperClient.current_frame );
            new MenuFrame();
        }
        else
            forward( command );
    }
}