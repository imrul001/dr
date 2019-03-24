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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping(value = "/cases")
public class CasesController {

    @Autowired
    CaseConversationService caseConversationService;

    @RequestMapping(value = {""})
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

    @RequestMapping(value = "/create")
    public String getCreateCaseView(){
        return "createcase";
    }

    @RequestMapping(value = "/do/create", method = RequestMethod.POST)
    public String createCase(@ModelAttribute("caseHistoryDTO") CaseHistoryDTO caseHistoryDTO, HttpServletRequest request){
        UserLogin userLogin = (UserLogin) request.getSession().getAttribute("userLogin");
        caseHistoryDTO.setClientId(userLogin.getClientId());
        caseConversationService.createCaseConversation(caseHistoryDTO);
        return "redirect:/summary";
    }

    @RequestMapping(value = "/history/detail/{caseId}", method = RequestMethod.GET)
    public String getCaseHistoryDetail(@PathVariable int caseId){
        return "casedetail";
    }


}
