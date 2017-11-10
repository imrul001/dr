package dr.hasan.provider;

import dr.hasan.clientLogin.entity.UserLogin;
import dr.hasan.clientLogin.service.UserLoginService;
import dr.hasan.clientRegistration.service.ClientRegistrationService;
import dr.hasan.response.MyResponse;
import dr.hasan.response.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;

@Component
public class DrAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserLoginService loginService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        if(email.length() > 0 && password.length() > 0){
            try{
                MyResponse response = loginService.getUserLoginAuthenticated(email, password);
                if(response.getResponseCode() == ResponseCode.OPERATION_SUCCESSFUL.getCode()){
                    UserLogin userLogin = (UserLogin) response.getItems();
                    return new UsernamePasswordAuthenticationToken(userLogin, userLogin.getToken(), new ArrayList<GrantedAuthority>());
                }else{
                    throw new DrUserStatusException(response.getErrors().get(0));
                }
            }catch (ResourceAccessException ex){
                throw new DrUserStatusException("Sorry!! Service Down");
            }
        }else{
            throw new DrUserStatusException("Invalid User Login Credentials");
        }
    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}


class DrUserStatusException extends AccountStatusException {
    public DrUserStatusException(String msg) {
        super(msg);
    }
}
