package dr.hasan.clientLogin.controller;

import dr.hasan.clientLogin.service.UserLoginService;
import dr.hasan.clientLogin.viewmodel.LoginDTO;
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


    @RequestMapping(value = {"","/login"}, method = RequestMethod.GET)
    public String viewLogInPage(Model model){
        return "login";
    }



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@ModelAttribute("UserLoginDTO") LoginDTO loginDTO, Model model){
        if(userLoginService.isValidUser(loginDTO.getEmail(), loginDTO.getPassword())){
            model.addAttribute("message", "Found User");
        }
        return "showmessage";
    }
}
