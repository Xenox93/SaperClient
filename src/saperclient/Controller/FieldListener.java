package saperclient.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import saperclient.Network.Requests.BoardRequest;

/**
 *
 * @author Damian
 */
public class FieldListener implements ActionListener {
    
    private final int row;
    private final int col;
    
    //==========================================================================
    
    public FieldListener( int row, int col ) {
        
        this.row = row;
        this.col = col;
    }
    
    //==========================================================================
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        
        BoardRequest.checkField( row, col );
    }
}