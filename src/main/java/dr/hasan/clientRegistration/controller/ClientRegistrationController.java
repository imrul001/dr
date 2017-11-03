package dr.hasan.clientRegistration.controller;

import dr.hasan.clientRegistration.service.ClientRegistrationService;
import dr.hasan.clientRegistration.viewmodel.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Imrul on 9/11/2017.
 */

@Controller
public class ClientRegistrationController {

    @Autowired
    private ClientRegistrationService registrationService;

    @RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
    public String showIndex(Model model){
        model.addAttribute("clientDTO", new ClientDTO());
        return "clientRegistrationForm";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String showDynamicSearchPage(){
        return "dynamicSearch";
    }

    @RequestMapping(value = "/do/client/registration", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> doClientRegistration(@RequestBody ClientDTO clientDTO){
        Map<String, Object> response = new HashMap<String, Object>();
        if(clientDTO.getName()!= null && !clientDTO.getName().isEmpty()){
            return registrationService.registerClient(clientDTO);
        }else{
            response.put("error", "empty object");
        }
        return response;
    }

}
