package dr.hasan.clientLogin.controller;

import dr.hasan.clientLogin.service.UserLoginService;
import dr.hasan.clientLogin.viewmodel.LoginDTO;
import dr.hasan.clientLogin.viewmodel.TestFormDto;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imrul on 10/13/2017.
 */

@Controller
public class LoginController {

    @Autowired
    private UserLoginService userLoginService;



    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String viewLogInPage(Model model){
        return "login";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String viewTestForm(Model model){
        TestFormDto testFormDto = new TestFormDto();
        List<Long> longs = new ArrayList<>();
        longs.add(null);
        longs.add(500L);
        longs.add(200L);
        longs.add(300L);
        longs.add(100L);

        List<String> strings = new ArrayList<>();
        strings.add(null);
        strings.add("4001");
        strings.add("3001");

        model.addAttribute("longs", longs);
        model.addAttribute("strings", strings);
        model.addAttribute("testFormDto", testFormDto);
        return "testform";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@ModelAttribute("UserLoginDTO") LoginDTO loginDTO, Model model){
        if(userLoginService.isValidUser(loginDTO.getEmail(), loginDTO.getPassword())){
            model.addAttribute("message", "Found User");
        }
        return "showmessage";
    }
}
