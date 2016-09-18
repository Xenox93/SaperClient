package saperclient.Network;

import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.InetAddress;
import java.net.Socket;

import saperclient.Exceptions.BlankCommandException;
import saperclient.Network.Interpreter.Interpreter;
import saperclient.SaperClient;

/**
 * @author Damian
 */
public class Client {
    
    private Socket socket = null;
    
    private ObjectOutputStream out = null;
    private ObjectInputStream in = null;
    
    private Interpreter interpreter = null;
    
    //==========================================================================

    public Client( String address, int port ) throws IOException {
        
        try
        {
            socket = new Socket( InetAddress.getByName( address ), port );
            
            in = new ObjectInputStream( socket.getInputStream() );
            out = new ObjectOutputStream( socket.getOutputStream() );
            
            if( interpreter == null )
                interpreter = new Interpreter( this );
        }
        catch( Exception e )
        {
            disconnect();
            
            throw e;
        }
    }
    
    //==========================================================================
    
    public final void disconnect() {
        
        try {
            
            if( out != null ) {
                out.close();
                out = null;
            }
            
            if( in != null ) {
                in.close();
                in = null;
            }
            
            if( interpreter != null )
                interpreter = null;
            
            if( socket != null ) {
                socket.close();
                socket = null;
            }
            
            SaperClient.client = null;
            
            System.out.println( "Disconnected !!!" );
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
            
        } catch( IOException e )
        {
            e.printStackTrace();
            disconnect();
            
            throw e;
        }
    }
    
    //--------------------------------------------------------------------------
    
    public void getMsgs() throws Exception {
        
       try {
           
           interpreter.exec( getMsg() );
           
       } catch( BlankCommandException ex ) {
       }
       
    }
    private NetRequest getMsg() throws Exception {
        
        String request = in.readObject().toString();
        
        if( request == null || request.isEmpty() )
            throw new BlankCommandException();
        
        System.out.println( request );
           
        JSONObject obj = new JSONObject( request );
        
        String service = obj.getString( "header" );
        String content = obj.getString( "data" );
           
        if( service.isEmpty() )
            throw new BlankCommandException();
        
        return new NetRequest( service, content );
    }
}
