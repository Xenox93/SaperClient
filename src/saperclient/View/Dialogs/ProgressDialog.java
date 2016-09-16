package saperclient.View.Dialogs;

import java.awt.Dimension;
import java.awt.Font;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import saperclient.SaperClient;

public class ProgressDialog extends JDialog {
    
    public ProgressDialog( String message ) {
    
        super( SaperClient.current_frame, "", false );
        
        SwingUtilities.invokeLater( new Runnable() {
            
            public void run() {
                
                setLayout( new GridBagLayout() );

                    addMessage( message );

                setMinimumSize( new Dimension( 300, 100 ) );

                // Create a transparent background
                /*setUndecorated( true );
                getRootPane().setOpaque(false);
                getContentPane().setBackground( new Color( 1, 1, 1, 0.7f ) );
                setBackground( new Color( 1, 1, 1, 0.7f ) );*/

                setVisible( false );
                setResizable( false );

                setLocationRelativeTo( null );
                setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
            }
        });
    }
    
    //==========================================================================
    
    private void addMessage( String message ) {
        
        JLabel msg_label = new JLabel( message );
        
            msg_label.setFont( msg_label.getFont().deriveFont(30.f).deriveFont( Font.BOLD ) );
        
        GridBagConstraints layout = new GridBagConstraints();
        
            layout.anchor = GridBagConstraints.CENTER;
            layout.insets = new Insets( 20, 20, 20, 20 );
            layout.gridx = 0;
            layout.gridy = 0;
        
        add( msg_label, layout );
    }
    
}