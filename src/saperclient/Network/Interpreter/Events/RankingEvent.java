package saperclient.Network.Interpreter.Events;

import com.google.gson.Gson;
import saperclient.Model.Ranking;
import saperclient.Network.Client;
import saperclient.Network.Interpreter.Event;
import saperclient.Network.NetRequest;

/**
 *
 * @author Damian
 */
public class RankingEvent extends Event {
    
    public static Ranking ranking;
    
    //==========================================================================
    
    public RankingEvent( Client client )
    {
        super( client );
    }
    
    //==========================================================================
    
    @Override
    public void handle( NetRequest command ) throws Exception
    {
        if( command.getHeader().equals( "ranking" ) ) {
            
            ranking = new Gson().fromJson( command.getData(), Ranking.class );
        }
        else
            forward( command );
    }
}