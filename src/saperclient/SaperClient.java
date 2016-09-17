package saperclient;

import javax.swing.JFrame;
import saperclient.Network.Client;
import saperclient.View.Frames.Login.LoginFrame;

public class SaperClient {
    
    public static final String SERVER_IP = "127.0.0.1";
    public static final int SERVER_PORT = 5252;
    
    public static Client client = null;
    public static JFrame current_frame = null;
    public static JFrame saved_frame = null;
    
    //==========================================================================
    
    public static void main(String[] args) {
        
        new LoginFrame();
    }
}
