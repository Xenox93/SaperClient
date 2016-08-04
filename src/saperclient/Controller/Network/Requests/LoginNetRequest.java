package saperclient.Controller.Network.Requests;

import saperclient.Controller.Network.NetRequest;

import saperclient.Model.Account;

/**
 * @author Damian
 */
public class LoginNetRequest extends NetRequest<Account> {
    
    public LoginNetRequest( Account account ) {
        
        service = "login";
        content = account;
    }
}
