package saperclient;

import saperclient.Login.Frames.Login.LoginFrame;
import saperclient.Controller.Network.Client;

public class SaperClient {
    
    public static void main(String[] args) {
        
        Client client = new Client( "192.168.0.100", 5252 );
        new LoginFrame();
        
        client.sendMsg( "login" );
    }
}
