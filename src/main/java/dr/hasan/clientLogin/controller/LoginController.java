package dr.hasan.clientLogin.controller;

import dr.hasan.aspect.userlogin.LogginBeforeUserLoginBusiness;
import dr.hasan.clientLogin.service.UserLoginService;
import dr.hasan.clientLogin.viewmodel.UserLoginDTO;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Imrul on 10/13/2017.
 */

@Controller
public class LoginController {

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewLogInPage(Model model){
        LogginBeforeUserLoginBusiness loginBusiness = new LogginBeforeUserLoginBusiness();

        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(userLoginService);
        proxyFactoryBean.addAdvice(loginBusiness);

        UserLoginService loginService = (UserLoginService) proxyFactoryBean.getObject();

        String username = loginService.getUserName();
        model.addAttribute("username",username);
        return "login";
    }



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@ModelAttribute("UserLoginDTO") UserLoginDTO userLoginDTO, Model model){
        if(userLoginService.isValiUser(userLoginDTO.getEmail(), userLoginDTO.getPassword()));
        return "message";
    }
}
