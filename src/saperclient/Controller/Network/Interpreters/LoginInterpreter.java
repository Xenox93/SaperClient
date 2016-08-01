package saperclient.Controller.Network.Interpreters;

import saperclient.Controller.Network.Client;
import saperclient.Controller.Network.Interpreter.Interpreter;
import saperclient.Controller.Network.Interpreters.Events.PrintEvent;

/**
 * @author Damian
 */
public class LoginInterpreter extends Interpreter {
    
    public LoginInterpreter( Client client ) {
        
        super();
        
        event = new PrintEvent( client );
    }
}
