package saperclient.View.Frames.Board;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import javax.swing.SwingUtilities;
import saperclient.Model.Level;

import saperclient.SaperClient;

/**
 *
 * @author Damian
 */
public class BoardFrame {
    
    private static final Dimension SIZE_BUTTON = new Dimension( 120, 30 );
    public static Level level = new Level( 0, 0, 0 );
    
    private JFrame frame;
    
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
    
    //==========================================================================
    
    private void addContent() {

          createBoard();
    }
    
    //--------------------------------------------------------------------------
    
    private void createBoard() {
    }
}
