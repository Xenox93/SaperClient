package saperclient.Network.Requests;

import com.google.gson.Gson;

import javax.swing.JDialog;

import saperclient.Network.Client;
import saperclient.Network.NetRequest;

import saperclient.View.Dialogs.MessageDialog;
import saperclient.View.Dialogs.ProgressDialog;

import saperclient.Model.Ranking;
import saperclient.SaperClient;
import saperclient.View.Frames.Login.Ranking.RankingFrame;

/**
 *
 * @author Damian
 */
public class RankingNetRequest {
    
    public static void getRanking() {
        
        JDialog dialog = new ProgressDialog( "Pobieranie rankingu..." );
        String msg = "";
        
        Thread dialog_thread = new Thread() {
            
            @Override
            public void run() {
                
                if( dialog != null && !dialog.isVisible() )
                    dialog.setVisible( true );
            }
            
            @Override
            public void interrupt() {
                
                if( dialog != null ) {
                    dialog.setVisible( false );
                    dialog.removeAll();
                    dialog.dispose();
                }
            }
        };
        
        //----------------------------------------------------------------------
        
        try {
            
            dialog_thread.start();
            
            if( SaperClient.client == null )
                SaperClient.client = new Client( SaperClient.SERVER_IP, SaperClient.SERVER_PORT );

            SaperClient.client.sendMsg( new NetRequest( "ranking", "" ) );
            //SaperClient.client.getMsgs();

        } catch( Exception e ) {
            msg = "Problem z połączeniem.";
            e.printStackTrace();

        } finally {
            
            dialog_thread.interrupt();
            
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