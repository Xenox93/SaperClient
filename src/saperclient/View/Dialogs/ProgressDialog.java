package saperclient.View.Dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.net.URL;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class ProgressDialog extends JDialog {
    
    private final JFrame parent;
    
    //==========================================================================
    
    public ProgressDialog( final String message, final JFrame parent ) {
    
        super( parent, "", true );
        
        this.parent = parent;
        
        setLayout( new GridBagLayout() );
        
            addContent2Panel( message );
        
        setMinimumSize( new Dimension( 600, 200 ) );
        
        // Create a transparent background
        setUndecorated( true );
        getRootPane().setOpaque(false);
        getContentPane().setBackground( new Color( 1, 1, 1, 0.7f ) );
        setBackground( new Color( 1, 1, 1, 0.7f ) );
        
        setLocationRelativeTo( null );
        setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
        
        setVisible( false );
    }
    
    //==========================================================================
    
    private void addContent2Panel( final String message ) {
        
        addProgressBar();
        addMessage( message );
    }
    
    //==========================================================================
    
    private void addProgressBar() {
        
        URL url = getClass().getResource("..//Resources//Spinners//spinner.gif" );
        Icon icon = new ImageIcon( url );
            
        GridBagConstraints layout = new GridBagConstraints();
        
            layout.anchor = GridBagConstraints.CENTER;
            layout.gridx = 0;
            layout.gridy = 0;
        
        add( new JLabel( icon ), layout );
    }
    private void addMessage( final String message ) {
        
        JLabel msg_label = new JLabel( message );
        
            msg_label.setFont( msg_label.getFont().deriveFont(30.f).deriveFont( Font.BOLD ) );
        
        GridBagConstraints layout = new GridBagConstraints();
        
            layout.anchor = GridBagConstraints.CENTER;
            layout.insets = new Insets( 20, 20, 20, 20 );
            layout.gridx = 1;
            layout.gridy = 0;
        
        add( msg_label, layout );
    }
    
}