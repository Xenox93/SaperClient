package saperclient.View.Frames.Login;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JFrame;
import saperclient.Controller.LoginListener;
import saperclient.SaperClient;

/**
 * @author Damian
 */
public class LoginFrame {
    
    private static final Dimension SIZE_BUTTON = new Dimension( 120, 30 );
    
    private JFrame frame;
    
    //==========================================================================
    
    public LoginFrame() {
        
        SwingUtilities.invokeLater( new Runnable() {
            
            public void run() {

                frame = new JFrame();

                frame.setLayout( new GridBagLayout() );
                frame.getRootPane().setBorder( BorderFactory.createEmptyBorder( 30, 60, 30, 60 ) );

                if( SaperClient.current_frame != null ) {
                    
                    SaperClient.current_frame.removeAll();
                    SaperClient.current_frame.dispose();
                    SaperClient.current_frame = null;
                }
                
                SaperClient.current_frame = frame;
                
                    addContent();

                frame.pack();

                frame.setVisible( true );
                frame.setResizable( false );

                frame.setLocationRelativeTo( null );
                frame.setTitle( "Saper - Logowanie" );
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            }
        });
    }
    
    //==========================================================================
    
    private void addContent() {

        addLoginTitle();
        
        addFormLoginPanel();
        
        addLoginButton();
        addRegisterButton();
    }
    
    private void addLoginTitle() {

        JLabel login_label = new JLabel( "Logowanie" );

            login_label.setFont( login_label.getFont().deriveFont( 30.f ) );

        GridBagConstraints layout = new GridBagConstraints();

            layout.anchor = GridBagConstraints.CENTER;
            layout.insets = new Insets( 0, 0, 0, 0 );
            layout.gridwidth = 2;
            layout.gridx = 0;
            layout.gridy = 0;

        frame.add( login_label, layout );
    }
    private void addFormLoginPanel() {
        
        new FormLoginPanel();
    }
    private void addLoginButton() {
        
        JButton login_button = new JButton( "Zaloguj" );

            login_button.setPreferredSize( SIZE_BUTTON );
            login_button.setName( "login" );
            login_button.addActionListener( new LoginListener() );
        
        GridBagConstraints layout = new GridBagConstraints();

            layout.anchor = GridBagConstraints.CENTER;
            layout.insets = new Insets( 20, 0, 0, 0 );
            layout.gridwidth = 1;
            layout.gridx = 0;
            layout.gridy = 3;

        frame.add( login_button, layout );
    }
    private void addRegisterButton() {
        
        JButton register_button = new JButton( "Zarejestruj" );

            register_button.setPreferredSize( SIZE_BUTTON );
            register_button.setName( "register" );
            register_button.addActionListener( new LoginListener() );
        
        GridBagConstraints layout = new GridBagConstraints();

            layout.anchor = GridBagConstraints.CENTER;
            layout.insets = new Insets( 20, 4, 0, 0 );
            layout.gridwidth = 1;
            layout.gridx = 1;
            layout.gridy = 3;

        frame.add( register_button, layout );
    }
}
