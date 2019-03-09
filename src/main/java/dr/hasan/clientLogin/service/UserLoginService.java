package dr.hasan.clientLogin.service;

import dr.hasan.clientLogin.entity.UserLogin;
import dr.hasan.clientLogin.repository.UserLoginRepository;
import dr.hasan.clientRegistration.entity.Client;
import dr.hasan.clientRegistration.repository.ClientRepository;
import dr.hasan.clientRegistration.service.ClientRegistrationService;
import dr.hasan.common.TokenGenerator;
import dr.hasan.response.MyResponse;
import dr.hasan.response.Response;
import dr.hasan.response.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Imrul on 10/13/2017.
 */

@Service
@Transactional
public class UserLoginService {

    @Autowired
    private ClientRegistrationService registrationService;

    @Autowired
    private UserLoginRepository userLoginRepository;


    public boolean isValidUser(String email, String password) {
        return registrationService.isExist(email, password);
    }

    public Client getClient(String email, String password) {
        return registrationService.getClient(email, password);
    }


    public MyResponse getUserLoginAuthenticated(String email, String password) {
        MyResponse response = new MyResponse();
        List<String> errors = new ArrayList<String>();
        Client client = this.getClient(email, password);
        if (client != null) {
            if (userLoginRepository.isExist(email)) {
                response.setResponseCode(ResponseCode.INVALID_ARGUMENT.getCode());
                errors.add(new String("An User of same Email is already Logged in"));
                response.setErrors(errors);
            } else {
                UserLogin userLogin = new UserLogin();
                userLogin.setEmail(email);
                userLogin.setToken(TokenGenerator.getToken(10));
                userLogin.setLoginTime(new Date());
                userLogin.setExpireTime(new Date());
                userLogin.setClientId(client.getId());
                userLoginRepository.save(userLogin);
                if (userLogin.getId() > 0) {
                    response.setItems(userLogin);
                    response.setResponseCode(ResponseCode.OPERATION_SUCCESSFUL.getCode());
                } else {
                    response.setResponseCode(ResponseCode.DATABASE_ERROR.getCode());
                }
            }
        } else {
            response.setResponseCode(ResponseCode.INVALID_ARGUMENT.getCode());
            errors.add(new String("Invalid User Login Credential"));
            response.setErrors(errors);
        }
        return response;
    }

    public boolean deleteUser(UserLogin userLogin) {
        boolean flag = false;
        String email = userLogin.getEmail();
        userLoginRepository.delete(userLogin);
        if (!userLoginRepository.isExist(email)) {
            flag = true;
        }
        return flag;
    }
}
