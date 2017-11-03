package dr.hasan.clientLogin.service;

import dr.hasan.clientRegistration.service.ClientRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Imrul on 10/13/2017.
 */

@Service
@Transactional
public class UserLoginService {

    private static final String username = "Imrul Hasan";
    @Autowired
    private ClientRegistrationService registrationService;

    public boolean isValidUser(String email, String password){
        return registrationService.isExist(email, password);
    }

    public String getUserName() {
        return username;
    }
}
