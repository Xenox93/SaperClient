package saperclient.View.Dialogs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MessageDialog extends JDialog {
    
    private final JPanel panel = new JPanel( new GridBagLayout() );
    
    //--------------------------------------------------------------------------
    
    JButton button;
    
    //==========================================================================
    
    public MessageDialog( final String message, final JFrame parent ) {
    
        super( parent, "", true );
        
        getContentPane().setBounds( 20, 20, 20, 20 );
        
            addContent2Panel( message );
        
        pack();
        
        setLocationRelativeTo( null );
        setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
        
        setVisible( true );
    }
    
    //==========================================================================
    
    private void addContent2Panel( final String message ) {
        
        addMessage( message );
        addOKButton();
        
        add( panel );
    }
    
    //==========================================================================
    
    private void addMessage( final String message ) {
        
        GridBagConstraints layout = new GridBagConstraints();
        
            layout.anchor = GridBagConstraints.CENTER;
            layout.gridx = 0;
            layout.gridy = 0;
        
        panel.add( new JLabel( message ), layout );
    }
    
    //--------------------------------------------------------------------------
    
    private void addOKButton() {
        
        GridBagConstraints layout = new GridBagConstraints();
        
            layout.anchor = GridBagConstraints.CENTER;
            layout.gridx = 0;
            layout.gridy = 1;
            
        button = new JButton( "OK" );
        
            button.addActionListener( new ActionListener() {
                
                @Override
                public void actionPerformed( ActionEvent e ) {
                    dispose();
                }
                
            });
        
        panel.add( button, layout );
    }
    
}
