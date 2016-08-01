package saperclient.View.Frames.Login;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import saperclient.Controller.LoginListener;

/**
 * @author Damian
 */
public class FormLoginPanel {
    
    private static final Dimension SIZE_TEXT_FIELD = new Dimension( 120, 20 );
    
    //==========================================================================
    
    private final JFrame frame;
    private final JPanel panel;
    
    private JTextField login_field;
    private JPasswordField password_field;
    
    //==========================================================================
    
    public FormLoginPanel( JFrame frame ) {
        
        this.frame = frame;
        
        panel = new JPanel( new GridBagLayout() );
        
            addContent();
        
        GridBagConstraints layout = new GridBagConstraints();

            layout.anchor = GridBagConstraints.CENTER;
            layout.insets = new Insets( 30, 0, 0, 0 );
            layout.gridwidth = 2;
            layout.gridx = 0;
            layout.gridy = 1;
            
        frame.add( panel, layout );
    }
    
    //==========================================================================
    
    public final String getLogin() {
        return login_field.getText();
    }
    public final String getPassword() {
        return String.valueOf( password_field.getPassword() );
    }
    
    //==========================================================================
    
    private void addContent() {

        addLoginLabel();
        addLoginField();

        addPasswordLabel();
        addPasswordField();
    }
    
    private void addLoginLabel() {

        GridBagConstraints layout = new GridBagConstraints();

            layout.anchor = GridBagConstraints.EAST;
            layout.insets = new Insets( 0, 0, 2, 2 );
            layout.gridwidth = 1;
            layout.gridx = 0;
            layout.gridy = 0;

        panel.add( new JLabel("Login"), layout );
    }
    private void addLoginField() {

        login_field = new JTextField();
        
            login_field.setPreferredSize( SIZE_TEXT_FIELD );
            login_field.addKeyListener( new LoginListener( frame, this ) );

        GridBagConstraints layout = new GridBagConstraints();

            layout.anchor = GridBagConstraints.WEST;
            layout.insets = new Insets( 0, 2, 2, 0 );
            layout.gridx = 1;

        panel.add( login_field, layout );
    }
    
    private void addPasswordLabel() {

        GridBagConstraints layout = new GridBagConstraints();

            layout.anchor = GridBagConstraints.EAST;
            layout.insets = new Insets( 0, 2, 2, 0 );
            layout.gridx = 0;
            layout.gridy = 1;

        panel.add( new JLabel("Hasło"), layout );
    }
    private void addPasswordField() {
        
        password_field = new JPasswordField();
        
            password_field.setPreferredSize( SIZE_TEXT_FIELD );
            password_field.addKeyListener( new LoginListener( frame, this ) );
        
        GridBagConstraints layout = new GridBagConstraints();

            layout.anchor = GridBagConstraints.WEST;
            layout.insets = new Insets( 0, 2, 2, 0 );
            layout.gridx = 1;

        panel.add( password_field, layout );
    }
}
