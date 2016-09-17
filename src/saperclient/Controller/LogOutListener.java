package saperclient.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import saperclient.SaperClient;
import saperclient.View.Frames.Login.LoginFrame;

/**
 *
 * @author Damian
 */
public class LogOutListener implements ActionListener {
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        
        if( SaperClient.client != null ) {
            
            SaperClient.client.disconnect();
            SaperClient.client = null;
        }
        
        new LoginFrame();
    }
}