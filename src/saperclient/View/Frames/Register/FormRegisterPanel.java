package saperclient.View.Frames.Register;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;

import javax.swing.JPanel;

import saperclient.Controller.LoginListener;
import saperclient.Controller.RegisterListener;

import saperclient.SaperClient;

/**
 *
 * @author Damian
 */
public class FormRegisterPanel {
    
    private static final Dimension SIZE_TEXT_FIELD = new Dimension( 120, 20 );
    
    //==========================================================================
    
    private final JPanel panel;
    
    private static JTextField login_field;
    private static JPasswordField password_field;
    
    //==========================================================================
    
    public FormRegisterPanel() {
        
        panel = new JPanel( new GridBagLayout() );
        
            addContent();
        
        GridBagConstraints layout = new GridBagConstraints();

            layout.anchor = GridBagConstraints.CENTER;
            layout.insets = new Insets( 30, 0, 0, 0 );
            layout.gridwidth = 2;
            layout.gridx = 0;
            layout.gridy = 1;
            
        SaperClient.current_frame.add( panel, layout );
    }
    
    //==========================================================================
    
    public static final String getLogin() {
        
        if( login_field == null )
            return "";
        
        return login_field.getText();
    }
    public static final String getPassword() {
        
        if( password_field == null )
            return "";
        
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
            login_field.addKeyListener( new RegisterListener() );

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
            password_field.addKeyListener( new RegisterListener() );
        
        GridBagConstraints layout = new GridBagConstraints();

            layout.anchor = GridBagConstraints.WEST;
            layout.insets = new Insets( 0, 2, 2, 0 );
            layout.gridx = 1;

        panel.add( password_field, layout );
    }
}