package saperserver.Login.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import saperclient.Login.Frames.Login.LoginFrame;

/**
 * @author Damian
 */
public class RegisterListener implements ActionListener {
    
    private JFrame frame;
    
    //==========================================================================
    
    public RegisterListener( JFrame frame ) {
        
        this.frame = frame;
    }
    
    //==========================================================================
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        
        new LoginFrame();
        frame.dispose();
    }
}
