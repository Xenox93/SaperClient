package saperclient.Network.Requests;

import com.google.gson.Gson;

import javax.swing.JDialog;

import saperclient.Exceptions.AccountExistException;
import saperclient.Exceptions.AccountRegisterFailedException;
import saperclient.Exceptions.BlankLoginDataException;
import saperclient.Exceptions.IncorrectLoginDataException;

import saperclient.Network.Client;
import saperclient.Network.NetRequest;

import saperclient.View.Dialogs.MessageDialog;
import saperclient.View.Dialogs.ProgressDialog;

import saperclient.View.Frames.Login.FormLoginPanel;
import saperclient.View.Frames.Login.LoginFrame;

import saperclient.Model.Account;

import saperclient.SaperClient;
import saperclient.View.Frames.Register.FormRegisterPanel;

/**
 * @author Damian
 */
public class LoginNetRequest {
    
    public static void signIn() {
        
        JDialog dialog = new ProgressDialog( "Logowanie..." );
        String msg = "";
        
        Thread dialog_thread = new Thread() {
            
            @Override
            public void run() {
                
                if( dialog != null && !dialog.isVisible() )
                    dialog.setVisible( true );
            }
            
            @Override
            public void interrupt() {
                
                if( dialog != null ) {
                    dialog.setVisible( false );
                    dialog.removeAll();
                    dialog.dispose();
                }
            }
        };
        
        //----------------------------------------------------------------------
        
        try {
            
            Account account = new Account( FormLoginPanel.getLogin(), FormLoginPanel.getPassword() );

            if( account.getLogin().isEmpty() || account.getPassword().isEmpty() )
                throw new BlankLoginDataException();
            
            dialog_thread.start();
            
            if( SaperClient.client == null )
                SaperClient.client = new Client( SaperClient.SERVER_IP, SaperClient.SERVER_PORT );

            SaperClient.client.sendMsg( new NetRequest( "login", new Gson().toJson( account, Account.class ) ) );
            SaperClient.client.getMsgs();

        } catch( BlankLoginDataException e ) {
            msg = "Wypełnij wszystkie pola.";

        } catch( IncorrectLoginDataException e ) {
            msg = "Niepoprawne dane logowania.";

        } catch( Exception e ) {
            msg = "Problem z połączeniem.";
            e.printStackTrace();

        } finally {
            
            dialog_thread.interrupt();
            
            if( !msg.isEmpty() )
                new MessageDialog( msg, SaperClient.current_frame );
            else
                new LoginFrame();
        }
    }
    public static void register() {
        
        JDialog dialog = new ProgressDialog( "Rejestrowanie..." );
        String msg = "";
        
        Thread dialog_thread = new Thread() {
            
            @Override
            public void run() {
                
                if( dialog != null && !dialog.isVisible() )
                    dialog.setVisible( true );
            }
            
            @Override
            public void interrupt() {
                
                if( dialog != null ) {
                    dialog.setVisible( false );
                    dialog.removeAll();
                    dialog.dispose();
                }
            }
        };
        
        //----------------------------------------------------------------------
        
        try {
            
            Account account = new Account( FormRegisterPanel.getLogin(), FormRegisterPanel.getPassword() );

            if( account.getLogin().isEmpty() || account.getPassword().isEmpty() )
                throw new BlankLoginDataException();
            
            dialog_thread.start();
            
            if( SaperClient.client == null )
                SaperClient.client = new Client( SaperClient.SERVER_IP, SaperClient.SERVER_PORT );

            SaperClient.client.sendMsg( new NetRequest( "register", new Gson().toJson( account, Account.class ) ) );
            SaperClient.client.getMsgs();

        } catch( BlankLoginDataException e ) {
            msg = "Wypełnij wszystkie pola.";

        } catch( AccountExistException e ) {
            msg = "Konto już istnieje.";

        } catch( AccountRegisterFailedException ex ) {
            msg = "Błędne rejestrowanie konta.";
            
        } catch( Exception e ) {
            msg = "Problem z połączeniem.";
            e.printStackTrace();

        } finally {
            
            if( dialog_thread != null ) {
                
                dialog_thread.interrupt();
                dialog_thread = null;
            }
            
            if( !msg.isEmpty() )
                new MessageDialog( msg, SaperClient.current_frame );
            else
                new LoginFrame();
        }
    }
}
