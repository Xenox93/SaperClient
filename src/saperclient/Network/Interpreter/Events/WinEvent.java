package saperclient.Network.Interpreter.Events;

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
public class WinEvent extends Event
{
    public WinEvent( Client client )
    {
        super( client );
    }
    
    //==========================================================================
    
    @Override
    public void handle( NetRequest command ) throws Exception
    {
        if( command.getHeader().equals( "win" ) ) {
            
            new MessageDialog( "Wygrałeś", SaperClient.current_frame );
            new MenuFrame();
        }
        else
            forward( command );
    }
}