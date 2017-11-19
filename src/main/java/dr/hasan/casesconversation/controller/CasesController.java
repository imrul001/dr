package dr.hasan.casesconversation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class CasesController {

    @RequestMapping(value = "/summary")
    public String getCaseSummary(Model model, HttpServletRequest request){
        return "summary";
    }

    @RequestMapping(value = "/session/test")
    public void getSessionTest(HttpServletRequest request){
        String token = (String) request.getSession().getAttribute("token");
    }

}
