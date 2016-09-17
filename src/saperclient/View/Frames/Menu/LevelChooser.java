package saperclient.View.Frames.Menu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import saperclient.Model.Level;

/**
 *
 * @author Damian
 */
public class LevelChooser extends JRadioButton {
    
    private final GridBagConstraints layout = new GridBagConstraints();
    
    private static JTextField custom_field_x_textfield ;
    private static JTextField custom_field_y_textfield;
    private static JTextField custom_mins_textfield;
    
    //--------------------------------------------------------------------------
    
    public LevelChooser() {
        
        setLayout( new GridBagLayout() );
        
        addLevelRadioButton( "Custom" );
        addInfoLevelLabel();
    }
    public LevelChooser( String level_name, int field_width, int field_height, int quantity_min ) {
        
        setLayout( new GridBagLayout() );
        
        addLevelRadioButton( level_name );
        addInfoLevelLabel( field_width, field_height, quantity_min );
    }
    
    //--------------------------------------------------------------------------
    
    public static void setEnable( boolean isEnabled ) {
        
        if( custom_field_x_textfield != null || custom_field_y_textfield != null || custom_mins_textfield != null ) {
            
            custom_field_x_textfield.setEditable(isEnabled );
            custom_field_x_textfield.setEnabled( isEnabled );
            
            custom_field_y_textfield.setEditable( isEnabled );
            custom_field_y_textfield.setEnabled( isEnabled );
            
            custom_mins_textfield.setEditable( isEnabled );
            custom_mins_textfield.setEnabled( isEnabled );
        }
    }
    public static final Level getLevel() {
        
        if( custom_field_x_textfield != null || custom_field_y_textfield != null || custom_mins_textfield != null )
            return new Level( Integer.valueOf( custom_field_x_textfield.getText() ),
                          Integer.valueOf( custom_field_y_textfield.getText() ),
                          Integer.valueOf( custom_mins_textfield.getText() ) );
        
        return new Level();
    }
    
    //==========================================================================
    
        private void addLevelRadioButton( String level_name ) {
        
        layout.anchor = GridBagConstraints.WEST;
        layout.insets = new Insets( 0, 20, 0, 0 );
        layout.gridx = 0;
        layout.gridy = 0;
        
        add( new JLabel( level_name ), layout );
    }
        private void addInfoLevelLabel( int field_width, int field_height, int quantity_min ) {
        
        layout.gridx = 1;
        
        add( new JLabel( "Field: " + field_width + " x " + field_height + "   Mins: " + quantity_min ), layout );
    }
    
    //--------------------------------------------------------------------------
    
    private void addInfoLevelLabel() {
        
        add( addCustomFieldLabel(), layout );
        
        add( addCustomFieldXTextField(), layout );
        add( addCustomFieldXLabel(), layout );
        
        add( addCustomFieldYTextField(), layout );
        add( addCustomFieldYLabel(), layout );
        
        add( addCustomNumberMinsTextField(), layout );
    }
    
        private JLabel addCustomFieldLabel() {

            layout.gridx = 1;

            return new JLabel( "Field:" );
        }
        private JTextField addCustomFieldXTextField() {

            layout.insets = new Insets( 0, 5, 0, 5 );
            layout.gridx = 2;

            custom_field_x_textfield = new JTextField();

                custom_field_x_textfield.setPreferredSize( new Dimension( 25, 15 ) );
                custom_field_x_textfield.setEditable(false );
                custom_field_x_textfield.setEnabled( false );

            return custom_field_x_textfield;
        }
        private JLabel addCustomFieldXLabel() {

            layout.insets = new Insets( 0, 0, 0, 0 );
            layout.gridx = 3;

            return new JLabel( "x" );
        }
        private JTextField addCustomFieldYTextField() {

            layout.insets = new Insets( 0, 5, 0, 20 );
            layout.gridx = 4;

            custom_field_y_textfield = new JTextField();

                custom_field_y_textfield.setPreferredSize( new Dimension( 25, 15 ) );
                custom_field_y_textfield.setEnabled( false );
                custom_field_y_textfield.setEditable(false );

            return custom_field_y_textfield;
        }
        private JLabel addCustomFieldYLabel() {

            layout.insets = new Insets( 0, 0, 0, 0 );
            layout.gridx = 5;

            return new JLabel( "Mins:" );
        }
        private JTextField addCustomNumberMinsTextField() {

            layout.insets = new Insets( 0, 5, 0, 0 );
            layout.gridx = 6;

            custom_mins_textfield = new JTextField();

                custom_mins_textfield.setPreferredSize( new Dimension( 25, 15 ) ); 
                custom_mins_textfield.setEnabled( false );
                custom_mins_textfield.setEditable(false );

            return custom_mins_textfield;
        }
}
