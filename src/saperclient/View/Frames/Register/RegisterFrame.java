package saperclient.View.Frames.Register;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.SwingUtilities;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JFrame;

import saperclient.Controller.RegisterListener;
import saperclient.SaperClient;

/**
 *
 * @author Damian
 */
public class RegisterFrame {
    
    private static final Dimension SIZE_BUTTON = new Dimension( 120, 30 );
    
    private JFrame frame;
    
    //==========================================================================
    
    public RegisterFrame() {
        
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
                frame.setTitle( "Saper - Rejestrowanie" );
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            }
        });
    }
    
    //==========================================================================
    
    private void addContent() {

        addRegisterTitle();
        
            addFormLoginPanel();
        
        addRegisterButton();
        addBackButton();
    }
    
    private void addRegisterTitle() {

        JLabel register_label = new JLabel( "Rejestrowanie" );

            register_label.setFont( register_label.getFont().deriveFont( 30.f ) );

        GridBagConstraints layout = new GridBagConstraints();

            layout.anchor = GridBagConstraints.CENTER;
            layout.insets = new Insets( 0, 0, 0, 0 );
            layout.gridwidth = 2;
            layout.gridx = 0;
            layout.gridy = 0;

        frame.add( register_label, layout );
    }
    private void addFormLoginPanel() {
        
        new FormRegisterPanel();
    }
    private void addRegisterButton() {
        
        JButton register_button = new JButton( "Zarejestruj" );

            register_button.setPreferredSize( SIZE_BUTTON );
            register_button.setName( "register" );
            register_button.addActionListener( new RegisterListener() );
        
        GridBagConstraints layout = new GridBagConstraints();

            layout.anchor = GridBagConstraints.CENTER;
            layout.insets = new Insets( 20, 0, 0, 0 );
            layout.gridwidth = 1;
            layout.gridx = 0;
            layout.gridy = 3;

        frame.add( register_button, layout );
    }
    private void addBackButton() {
        
        JButton back_button = new JButton( "Anuluj" );

            back_button.setPreferredSize( SIZE_BUTTON );
            back_button.setName( "back" );
            back_button.addActionListener( new RegisterListener());
        
        GridBagConstraints layout = new GridBagConstraints();

            layout.anchor = GridBagConstraints.CENTER;
            layout.insets = new Insets( 20, 4, 0, 0 );
            layout.gridwidth = 1;
            layout.gridx = 1;
            layout.gridy = 3;

        frame.add( back_button, layout );
    }
}
