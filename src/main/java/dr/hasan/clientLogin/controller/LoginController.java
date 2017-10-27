package dr.hasan.clientLogin.controller;

import dr.hasan.clientLogin.service.UserLoginService;
import dr.hasan.clientLogin.viewmodel.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Imrul on 10/13/2017.
 */

@Controller
public class LoginController {

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewLogInPage(Model model){
        String username = userLoginService.getUserName();
        model.addAttribute("username",username);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@ModelAttribute("UserLoginDTO") UserLoginDTO userLoginDTO, Model model){
        if(userLoginService.isValiUser(userLoginDTO.getEmail(), userLoginDTO.getPassword()));
        return "message";
    }
}
