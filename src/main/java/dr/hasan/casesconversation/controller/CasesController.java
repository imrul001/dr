package dr.hasan.casesconversation.controller;


import dr.hasan.casesconversation.model.CaseHistoryDTO;
import dr.hasan.casesconversation.service.CaseConversationService;
import dr.hasan.clientLogin.entity.UserLogin;
import dr.hasan.response.MyResponse;
import dr.hasan.response.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class CasesController {

    @Autowired
    CaseConversationService caseConversationService;

    @RequestMapping(value = "/summary")
    public String getCaseSummary(Model model,HttpServletRequest request) {
        UserLogin userLogin = (UserLogin) request.getSession().getAttribute("userLogin");
        MyResponse<List<CaseHistoryDTO>> listMyResponse = caseConversationService.getCaseHistory(userLogin);
        if (listMyResponse.getResponseCode() == ResponseCode.OPERATION_SUCCESSFUL.getCode()) {
            model.addAttribute("cases", listMyResponse.getItems());
        }
        model.addAttribute("hello", "hello world");
        return "summary";
    }

    @RequestMapping(value = "/session/test")
    public void getSessionTest(HttpServletRequest request) {
        String token = (String) request.getSession().getAttribute("token");
    }

}
