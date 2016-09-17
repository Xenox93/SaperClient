package saperclient.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import saperclient.Network.Requests.RankingNetRequest;

/**
 *
 * @author Damian
 */
public class RankingListener implements ActionListener {
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        
        RankingNetRequest.getRanking();
    }
}
