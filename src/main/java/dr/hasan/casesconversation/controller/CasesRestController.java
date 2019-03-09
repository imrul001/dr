package dr.hasan.casesconversation.controller;

import dr.hasan.casesconversation.entity.CaseHistory;
import dr.hasan.casesconversation.entity.Conversation;
import dr.hasan.casesconversation.model.CaseHistoryDTO;
import dr.hasan.casesconversation.service.CaseConversationService;
import dr.hasan.clientLogin.entity.UserLogin;
import dr.hasan.response.MyResponse;
import dr.hasan.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Imrul Hasan
 * @date 09/03/19
 */

@RestController
public class CasesRestController {

    @Autowired
    private CaseConversationService caseConversationService;

    @RequestMapping(value = "/create/case/history", method = RequestMethod.POST)
    public @ResponseBody
    Response createCaseHistory(@RequestBody CaseHistory caseHistory) {
        Response response = caseConversationService.createCaseConversation(caseHistory);
        return response;
    }

    @RequestMapping(value = "/create/case/conversation", method = RequestMethod.POST)
    public @ResponseBody
    Response createCaseHistory(@RequestBody Conversation conversation) {
        Response response = caseConversationService.createConversation(conversation);
        return response;
    }

    @RequestMapping(value = "/get/all/case/history", method = RequestMethod.POST)
    public @ResponseBody
    MyResponse<List<CaseHistoryDTO>> getAllCaseHistory(@RequestBody UserLogin userLogin) {
        MyResponse<List<CaseHistoryDTO>> caseHistories = caseConversationService.getCaseHistory(userLogin);
        return caseHistories;
    }

    @RequestMapping(value = "/sayhello")
    public @ResponseBody
    String sayHello() {
        return "hello imrul";
    }
}
