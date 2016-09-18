package saperclient.Network.Requests;

import com.google.gson.Gson;

import saperclient.Exceptions.*;
import saperclient.Network.*;

import javax.swing.JDialog;
import saperclient.View.Dialogs.*;
import saperclient.View.Frames.Login.*;
import saperclient.View.Frames.Menu.MenuFrame;
import saperclient.View.Frames.Register.FormRegisterPanel;

import saperclient.Model.Account;
import saperclient.SaperClient;

/**
 * @author Damian
 */
public class LoginNetRequest {
    
    public static void signIn() {
        
        String msg = "";
        
        try {
            
            Account account = new Account( FormLoginPanel.getLogin(), FormLoginPanel.getPassword() );

            if( account.getLogin().isEmpty() || account.getPassword().isEmpty() )
                throw new BlankLoginDataException();
            
            if( SaperClient.client == null )
                SaperClient.client = new Client( SaperClient.SERVER_IP, SaperClient.SERVER_PORT );

            SaperClient.client.sendMsg( new NetRequest( "login", new Gson().toJson( account, Account.class ) ) );
            SaperClient.client.getMsgs();

        } catch( BlankLoginDataException e ) {
            msg = "Fill all fields";

        } catch( IncorrectLoginDataException e ) {
            msg = "Incorrect login data";

        } catch( Exception e ) {
            msg = "The problem with the connection";
            e.printStackTrace();

        } finally {
            
            if( !msg.isEmpty() )
                new MessageDialog( msg, SaperClient.current_frame );
            else
                new MenuFrame();
        }
    }
    public static void register() {
        
        String msg = "";
        
        try {
            
            Account account = new Account( FormRegisterPanel.getLogin(), FormRegisterPanel.getPassword() );

            if( account.getLogin().isEmpty() || account.getPassword().isEmpty() )
                throw new BlankLoginDataException();
            
            if( SaperClient.client == null )
                SaperClient.client = new Client( SaperClient.SERVER_IP, SaperClient.SERVER_PORT );

            SaperClient.client.sendMsg( new NetRequest( "register", new Gson().toJson( account, Account.class ) ) );
            SaperClient.client.getMsgs();

        } catch( BlankLoginDataException e ) {
            msg = "Fill all fields";

        } catch( AccountExistException e ) {
            msg = "Account already exist";

        } catch( AccountRegisterFailedException ex ) {
            msg = "Failed signup account";
            
        } catch( Exception e ) {
            msg = "The problem with the connection";
            e.printStackTrace();

        } finally {
            
            if( !msg.isEmpty() )
                new MessageDialog( msg, SaperClient.current_frame );
            else
                new LoginFrame();
        }
    }
}
