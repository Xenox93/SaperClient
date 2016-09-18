package saperclient.View.Frames.Board;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JFrame;
import saperclient.Controller.FieldListener;

import saperclient.Model.Board;
import saperclient.Model.Level;

import saperclient.SaperClient;

/**
 *
 * @author Damian
 */
public class BoardFrame {
    
    private static final Dimension SIZE_BUTTON = new Dimension( 30, 30 );
    
    private static List< List< JButton > > fields = new ArrayList<>();
    
    public static Level level = null;
    public static Board board = null;
    
    //--------------------------------------------------------------------------
    
    private JFrame frame = null;
    
    //==========================================================================
    
    public BoardFrame() {
        
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
                frame.setTitle( "Saper - Plansza" );
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            }
        });
    }
    
    //--------------------------------------------------------------------------
    
    public static void update() {
        
        for( int row = 0; row < board.getFields().size(); ++row )
            for( int col = 0; col < board.getFields().get( row ).size(); ++col ) {
                
                String text = board.getFields().get( row ).get( col );
                
                if( text.isEmpty() )
                    continue;
                
                if( !text.equals( "0" ) )
                    fields.get( row ).get( col ).setText( text );
                
                fields.get( row ).get( col ).setEnabled( false );
                fields.get( row ).get( col ).setSelected( true );
            }
    }
    
    //==========================================================================
    
    private void addContent() {

          createBoard();
    }
    
    //--------------------------------------------------------------------------
    
    private void createBoard() {
        
        fields = new ArrayList<>();
        
        for( int row = 0; row < board.getFields().size(); ++row ) {
            
            fields.add( new ArrayList<>() );
            
            for( int col = 0; col < board.getFields().get( row ).size(); ++col ) {
                
                fields.get( row ).add( new JButton( board.getFields().get( row ).get( col ) ) );
                
                    fields.get( row ).get( col ).setMargin( new Insets( 0, 0, 0, 0 ) );
                    fields.get( row ).get( col ).setPreferredSize( SIZE_BUTTON );
                    fields.get( row ).get( col ).addActionListener( new FieldListener( row, col ) );
                
                GridBagConstraints layout = new GridBagConstraints();

                    layout.anchor = GridBagConstraints.CENTER;
                    layout.insets = new Insets( 0, 0, 0, 0 );
                    layout.gridwidth = 1;
                    layout.gridx = col;
                    layout.gridy = row;

                frame.add( fields.get( row ).get( col ), layout );
            }
        }
    }
}
