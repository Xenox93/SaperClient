package saperclient.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import saperclient.Network.Requests.LoginNetRequest;
import saperclient.View.Frames.Login.LoginFrame;

/**
 * @author Damian
 */
public class RegisterListener extends KeyAdapter implements ActionListener {
    
    @Override
    public void keyReleased( KeyEvent e ) {
        
        if( e.getKeyCode() == KeyEvent.VK_ENTER )
            LoginNetRequest.register();
    }
    
    //--------------------------------------------------------------------------
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        
        JButton button = (JButton)e.getSource();
        
        if( button.getName().equals( "register" ) )
            LoginNetRequest.register();
        else if( button.getName().equals( "back" ) ) {
            new LoginFrame();
        }
    }
}
