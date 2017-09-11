package dr.hasan.clientRegistration.controller;

import dr.hasan.clientRegistration.service.ClientRegistrationService;
import dr.hasan.clientRegistration.viewmodel.ClientDTO;
import dr.hasan.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Imrul on 9/11/2017.
 */

@Controller
public class ClientRegistrationController {

    @Autowired
    private ClientRegistrationService registrationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex(Model model){
        model.addAttribute("clientDTO", new ClientDTO());
        return "home";
    }

    @RequestMapping(value = "/do/client/registration", method = RequestMethod.POST)
    public Response doClientRegistration(ClientDTO clientDTO){
        return registrationService.registerClient(clientDTO);
    }

}
