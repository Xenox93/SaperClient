package saperclient.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JFrame;

import saperclient.Controller.Network.Client;
import saperclient.Controller.Network.Requests.LoginNetRequest;
import saperclient.Model.Account;

import saperclient.Model.Exceptions.Account.BlankLoginDataException;
import saperclient.Model.Exceptions.Account.IncorrectLoginDataException;

import saperclient.View.Dialogs.MessageDialog;
import saperclient.View.Dialogs.ProgressDialog;

import saperclient.View.Frames.Login.FormLoginPanel;

/**
 * @author Damian
 */
public class LoginListener extends KeyAdapter implements ActionListener {
    
    private final FormLoginPanel form_login_panel;
    private final JFrame frame;
    
    //==========================================================================
    
    public LoginListener( JFrame frame, FormLoginPanel form_login_panel ) {
        
        this.frame = frame;
        this.form_login_panel = form_login_panel;
    }
    
    //==========================================================================
    
    @Override
    public void keyReleased( KeyEvent e ) {
        
        if( e.getKeyCode() == KeyEvent.VK_ENTER )
            signIn();
    }
    
    //--------------------------------------------------------------------------
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        
        JButton button = (JButton)e.getSource();
        
        if( button.getName().equals( "login" ) )
            signIn();
        else if( button.getName().equals( "register" ) ) {
            //new RegisterFrame();
            frame.dispose();
        }
    }
    
    //==========================================================================
    
    private void signIn() {
        
        Thread dialog_thread = new Thread() {
            
            private final JDialog dialog = new ProgressDialog( "Logowanie", frame );
                
            @Override
            public void run() {
                
                if( dialog != null && !dialog.isVisible() )
                dialog.setVisible( true );
            }
            
            @Override
            public void interrupt() {
            
                dialog.setVisible(false);
                dialog.dispose();
            }
        };
        
        Thread thread = new Thread() {
            
            @Override
            public void run() {
                
                String msg = "";
                
                try {
                    
                    dialog_thread.start();
                    
                        login( new Account( form_login_panel.getLogin(), form_login_panel.getPassword() ) );
                        
                    dialog_thread.interrupt();

                    //new RegisterFrame();
                    frame.dispose();
                
                } catch( BlankLoginDataException e ) {
                    
                    msg = "Wypełnij wszystkie pola.";
                    dialog_thread.interrupt();
                
                } catch( IncorrectLoginDataException e ) {
                    
                    msg = "Niepoprawne dane logowania.";
                    dialog_thread.interrupt();
                
                } catch( Exception e ) {
                    
                    msg = "Problem z połączeniem.";
                    dialog_thread.interrupt();
                    e.printStackTrace();
                }
                
                if( !msg.isEmpty() )
                    new MessageDialog( msg, frame );
                
                interrupt();
            }
        };
        
        thread.start();
    }
    
    //==========================================================================
    
    private void login( Account account ) throws Exception {
        
        if( account.getLogin().isEmpty() || account.getPassword().isEmpty() )
            throw new BlankLoginDataException();
        
        Client client = new Client( "192.168.0.100", 5252 );
        
            client.sendMsg( new LoginNetRequest( account ) );
            client.getMsgs();
        
        client.disconnect();
    }
}
