package saperclient.Controller.Network.Interpreters.Events;

import saperclient.Controller.Network.Interpreter.Event;

/**
 * @author Damian
 */
public class PrintEvent extends Event
{
    public PrintEvent()
    {
        super();
    }
    
    @Override
    public void handle( String command )
    {
        if( command.isEmpty() )
            return;
        
        if( command.equals( "login" ) )
            System.out.println( "login" );
        else
            forward( command );
    }
}
