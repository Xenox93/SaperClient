package saperclient.Controller.Network;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.InetAddress;
import java.net.Socket;

import saperclient.Controller.Network.Exceptions.BlankCommandException;
import saperclient.Controller.Network.Interpreter.Interpreter;
import saperclient.Controller.Network.Interpreters.LoginInterpreter;
import saperclient.Controller.Network.Requests.LoginNetRequest;
import saperclient.Model.Account;

/**
 * @author Damian
 */
public class Client {
    
    private Socket socket;
    
    private ObjectOutputStream out;
    private ObjectInputStream in;
    
    private Interpreter interpreter = new LoginInterpreter( this );
    
    //==========================================================================

    public Client( String address, int port ) throws IOException {
        
        try
        {
            socket = new Socket( InetAddress.getByName( address ), port );
            
            in = new ObjectInputStream( socket.getInputStream() );
            out = new ObjectOutputStream( socket.getOutputStream() );
        }
        catch( Exception e )
        {
            e.printStackTrace();
            disconnect();
            
            throw e;
        }
    }
    
    //==========================================================================
    
    public final void disconnect() {
        
        try {
            socket.close();
        }
        catch( Exception e ) {
        }
    }
    
    //==========================================================================
    
    public void sendMsg( NetRequest cmd ) throws IOException  {
        
        try
        {
            out.writeObject( new Gson().toJson( cmd ) );
            out.flush();
        }
        catch( IOException e )
        {
            e.printStackTrace();
            disconnect();
            
            throw e;
        }
    }
    
    //--------------------------------------------------------------------------
    
    public void getMsgs() throws Exception {
        
       while( true )
       {
           try {
               
               interpreter.exec( getMsg() );
               
               return;
               
           } catch( BlankCommandException e ) {
               
           } catch( Exception e ) {
               
               e.printStackTrace();
               disconnect();
               
               throw e;
           }
        }
    }
    private NetRequest getMsg() throws Exception {
        
        try {
            
            String request = in.readObject().toString();
        
            if( request.isEmpty() )
                throw new BlankCommandException();

            System.out.println( request );

            return new Gson().fromJson( request, LoginNetRequest.class );
        
        } catch( java.io.EOFException e ) {
            
            throw new BlankCommandException();
        }
    }
}
