package saperclient.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import saperclient.Exceptions.BlankLoginDataException;
import saperclient.Exceptions.IncorrectLoginDataException;

import saperclient.View.Frames.Login.FormLoginPanel;
import saperclient.View.Frames.Login.LoginFrame;

/**
 * @author Damian
 */
public class RegisterListener implements ActionListener {
    
    private final FormLoginPanel form_login_panel;
    private final JFrame frame;
    
    //==========================================================================
    
    public RegisterListener( JFrame frame, FormLoginPanel form_login_panel ) {
        
        this.frame = frame;
        this.form_login_panel = form_login_panel;
    }
    
    //==========================================================================
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        
        Thread dialog_thread = new Thread() {
            
            //private JDialog dialog;
                
            @Override
            public void run() {
                
                /*if( dialog == null ) {
                    
                    dialog = new ProgressDialog( "Logowanie", parent );
                    dialog.setVisible( true );
                }*/
            }
            
            @Override
            public void interrupt() {
            
                /*dialog.setVisible(false);
                dialog.dispose();*/
            }
        };
        
        Thread thread = new Thread() {
            
            @Override
            public void run() {
            
                dialog_thread.start();
                
                    String msg;

                    try {

                        register( form_login_panel.getLogin(), form_login_panel.getPassword() );

                        new LoginFrame();
                        frame.dispose();msg = "";

                    } catch( BlankLoginDataException ex ) {

                        msg = "Wypełnij wszystkie pola.";

                    } catch( IncorrectLoginDataException ex ) {

                        msg = "Nie można było zalogować.";

                    }
                
                dialog_thread.interrupt();
                
                /*if( !msg.isEmpty() )
                    new MessageDialog( msg );*/
                
                interrupt();
            }
        };
        
        thread.start();
    }
    
    //==========================================================================
    
    private void register( final String login, final String password ) throws BlankLoginDataException, IncorrectLoginDataException {
        
        if( login.isEmpty() || password.isEmpty() )
            throw new BlankLoginDataException();
        
        /*try {
            
            
            
        } catch( IncorrectLoginDataException ex ) {
            throw new IncorrectLoginDataException();
        }*/
    }
}
