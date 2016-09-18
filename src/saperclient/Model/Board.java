package saperclient.Model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Damian
 */
public class Board {
    
    private List< List< String > > output_fields = new ArrayList<>();
    
    //==========================================================================
    
    public final List< List< String > > getFields() {
        
        return output_fields;
    }
}
