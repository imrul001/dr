package dr.hasan.casesconversation.controller;


import dr.hasan.casesconversation.model.CaseHistoryDTO;
import dr.hasan.casesconversation.service.CaseConversationService;
import dr.hasan.clientLogin.entity.UserLogin;
import dr.hasan.response.MyResponse;
import dr.hasan.response.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/create/case")
    public String getCreateCaseView(){
        return "createcase";
    }


    @RequestMapping(value = "/do/create/case", method = RequestMethod.POST)
    public String createCase(@ModelAttribute("caseHistoryDTO") CaseHistoryDTO caseHistoryDTO, HttpServletRequest request){
        UserLogin userLogin = (UserLogin) request.getSession().getAttribute("userLogin");
        caseHistoryDTO.setClientId(userLogin.getClientId());
        caseConversationService.createCaseConversation(caseHistoryDTO);
        return "redirect:/summary";
    }


}
