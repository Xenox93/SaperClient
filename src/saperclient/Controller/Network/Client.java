package saperclient.Controller.Network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.InetAddress;
import java.net.Socket;

import saperclient.Controller.Network.Exceptions.BlankCommandException;
import saperclient.Controller.Network.Interpreter.Interpreter;
import saperclient.Controller.Network.Interpreters.LoginInterpreter;

/**
 * @author Damian
 */
public class Client {
    
    private Socket socket;
    
    private ObjectOutputStream out;
    private ObjectInputStream in;
    
    private Interpreter interpreter = new LoginInterpreter( this );
    
    //==========================================================================

    public Client( String address, int port ) {
        
        try
        {
            socket = new Socket( InetAddress.getByName( address ), port );
            
            in = new ObjectInputStream( socket.getInputStream() );
            out = new ObjectOutputStream( socket.getOutputStream() );
        }
        catch( IOException e )
        {
            e.getStackTrace();
            disconnect();
        }
    }
    
    //==========================================================================
    
    public final void disconnect() {
        
        try
        {
            socket.close();
        }
        catch( Exception e )
        {
            e.getStackTrace();
        }
    }
    
    //==========================================================================
    
    public void sendMsg( Request cmd ) {
        
        try
        {
            out.writeObject( cmd.toString() );
            out.flush();
        }
        catch( IOException e )
        {
            e.getStackTrace();
            disconnect();
        }
    }
    public void getMsgs() {
        
       while( true )
       {
           try {
               
               interpreter.exec( getMsg() );
               return;
               
           } catch( BlankCommandException e ) {
               
               e.getStackTrace();
               disconnect();
           }
        }
    }
    private Request getMsg() throws BlankCommandException {
        
        try
        {
           if( !socket.isClosed() ) {
               
               String request = in.readObject().toString();
               
               if( request.isEmpty() )
                   throw new BlankCommandException();
               
               return new Request( request );
           }
        }
        catch( IOException | ClassNotFoundException e )
        {
            e.getStackTrace();
            disconnect();
        }
        
        throw new BlankCommandException();
    }
}
