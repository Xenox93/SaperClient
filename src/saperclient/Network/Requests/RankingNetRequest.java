package saperclient.Network.Requests;

import saperclient.Network.*;

import javax.swing.JDialog;
import saperclient.View.Dialogs.*;
import saperclient.View.Frames.Ranking.RankingFrame;

import saperclient.SaperClient;

/**
 *
 * @author Damian
 */
public class RankingNetRequest {
    
    public static void getRanking() {
        
        String msg = "";
        
        try {
            
            if( SaperClient.client == null )
                SaperClient.client = new Client( SaperClient.SERVER_IP, SaperClient.SERVER_PORT );

            SaperClient.client.sendMsg( new NetRequest( "ranking", "" ) );
            SaperClient.client.getMsgs();

        } catch( Exception e ) {
            msg = "Problem z połączeniem.";
            e.printStackTrace();

        } finally {
            
            if( !msg.isEmpty() ) {
                
                new MessageDialog( msg, SaperClient.current_frame );
            
            } else if( SaperClient.current_frame != null ) {
                
                SaperClient.saved_frame = SaperClient.current_frame;
                SaperClient.saved_frame.setVisible( false );
                
                SaperClient.current_frame = null;
                new RankingFrame();
            }
        }
    }
}