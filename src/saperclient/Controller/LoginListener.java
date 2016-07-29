package saperserver.Login.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

import javax.swing.JFrame;
import saperclient.Login.Frames.Login.FormLoginPanel;

/**
 * @author Damian
 */
public class LoginListener extends KeyAdapter implements ActionListener {
    
    private FormLoginPanel form_login_panel;
    private JFrame frame;
    
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
        
        /*JDialog dialog;
        
        if( isEmpty() )
            dialog = new MessageDialog( "Wypełnij wszystkie pola.", parent );
        else {
            
            Thread thread = new Thread() {
                 
                private final JDialog dialog = new ProgressDialog( "Logowanie", parent );
                
                @Override
                public void run() {
                    if( !dialog.isVisible() )
                        dialog.setVisible( true );
                }
                
                @Override
                public void interrupt() {
                    dialog.setVisible(false);
                    parent.remove(dialog);
                    dialog.dispose();
                };
                
             };
            
            Thread thread1 = new Thread() {
                 
                private JDialog dialog;
                
                @Override
                public void run() {
                    
                    thread.start();
                    
                    if( Account.getInstance().signIn( getIndex(), getPassword() ) ) {
                        
                        thread.interrupt();
                        new TimetableFrame();
                        parent.dispose();
                        
                        interrupt();
                        
                    } else {
                        
                        thread.interrupt();
                        dialog = new MessageDialog( "Nie można było zalogować.", parent );
                        interrupt();
                    }
                }
                
            };
            
            thread1.start();
        }*/
    }
    
}
