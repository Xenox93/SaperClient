package saperclient.Network.Requests;

import com.google.gson.Gson;
import javax.swing.JDialog;

import org.json.JSONObject;
import saperclient.Model.Level;

import saperclient.Network.*;
import saperclient.SaperClient;

import saperclient.View.Dialogs.*;

import saperclient.View.Frames.Board.BoardFrame;

/**
 *
 * @author Damian
 */
public class BoardRequest {
    
    public static void getBoard() {
        
        JDialog dialog = new ProgressDialog( "Pobieranie planszy..." );
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

            SaperClient.client.sendMsg( new NetRequest( "prepare_board", new Gson().toJson( BoardFrame.level, Level.class ) ) );
            SaperClient.client.getMsgs();

        } catch( Exception e ) {
            msg = "Problem z połączeniem.";
            e.printStackTrace();

        } finally {
            
            dialog_thread.interrupt();
            
            if( !msg.isEmpty() )
                new MessageDialog( msg, SaperClient.current_frame );
        }
    }
    public static void checkField( int row, int col ) {
        
        JDialog dialog = new ProgressDialog( "Czekanie na odpowiedź serwera..." );
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

            JSONObject board_object = new JSONObject();
                
                board_object.put( "row", row );
                board_object.put( "col", col );
                
            SaperClient.client.sendMsg( new NetRequest( "check_field", board_object.toString() ) );
            SaperClient.client.getMsgs();

        } catch( Exception e ) {
            msg = "Problem z połączeniem.";
            e.printStackTrace();

        } finally {
            
            dialog_thread.interrupt();
            
            if( !msg.isEmpty() )
                new MessageDialog( msg, SaperClient.current_frame );
        }
    }
}
