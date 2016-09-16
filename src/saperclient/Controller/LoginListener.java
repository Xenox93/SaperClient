package saperclient.Controller;

import com.google.gson.Gson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JFrame;

import saperclient.Network.Client;
import saperclient.Network.Requests.LoginNetRequest;
import saperclient.Model.Account;

import saperclient.Exceptions.BlankLoginDataException;
import saperclient.Exceptions.IncorrectLoginDataException;
import saperclient.Network.NetRequest;
import saperclient.SaperClient;

import saperclient.View.Dialogs.MessageDialog;
import saperclient.View.Dialogs.ProgressDialog;

import saperclient.View.Frames.Login.FormLoginPanel;

/**
 * @author Damian
 */
public class LoginListener extends KeyAdapter implements ActionListener {
    
    @Override
    public void keyReleased( KeyEvent e ) {
        
        if( e.getKeyCode() == KeyEvent.VK_ENTER )
            LoginNetRequest.signIn();
    }
    
    //--------------------------------------------------------------------------
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        
        JButton button = (JButton)e.getSource();
        
        if( button.getName().equals( "login" ) )
            LoginNetRequest.signIn();
        else if( button.getName().equals( "register" ) ) {
            //new RegisterFrame();
        }
    }
}
