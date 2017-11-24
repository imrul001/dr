package dr.hasan.casesconversation.service;


import dr.hasan.casesconversation.entity.CaseHistory;
import dr.hasan.casesconversation.entity.Conversation;
import dr.hasan.casesconversation.repository.CaseHistoryRepository;
import dr.hasan.casesconversation.repository.ConversationRepository;
import dr.hasan.clientLogin.entity.UserLogin;
import dr.hasan.common.enums.YesNo;
import dr.hasan.response.MyResponse;
import dr.hasan.response.Response;
import dr.hasan.response.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CaseConversationService {

    @Autowired
    private CaseHistoryRepository caseHistoryRepository;

    @Autowired
    private ConversationRepository conversationRepository;

    public Response createCaseConversation(){

        Response response = new Response();
        try {
            CaseHistory caseHistory = new CaseHistory();
            caseHistory.setIsActive('Y');
            caseHistory.setPatientEmail("bimpu@gmail.com");
            caseHistory.setPatientId(1);

            Conversation conversation = new Conversation();
            conversation.setContent("Test Content from patient");
            conversation.setDate(new Date());
            conversation.setImage_id(123);
            conversation.setIsActive('Y');
//            conversation.setCaseHistory(caseHistory);

            Conversation conversation1 = new Conversation();
            conversation1.setContent("Second Test Content from patient");
            conversation1.setDate(new Date());
            conversation1.setImage_id(321);
            conversation1.setIsActive(YesNo.YES.getCode());
//            conversation1.setCaseHistory(caseHistory);


            List<Conversation> conversationList = new ArrayList<Conversation>();
            conversationList.add(conversation);
            conversationList.add(conversation1);

            caseHistory.setConversations(conversationList);

            caseHistoryRepository.create(caseHistory);
            response.setResponseCode(ResponseCode.OPERATION_SUCCESSFUL.getCode());

        }catch (Exception e){
            response.setResponseCode(ResponseCode.DATABASE_ERROR.getCode());
        }
        return response;

    }

    public MyResponse<List<CaseHistory>> getCaseHistory(UserLogin userLogin){
        MyResponse myResponse = new MyResponse();
        List<CaseHistory> caseHistories;
        try{
            caseHistories = caseHistoryRepository.getCaseHistoriesByEmail(userLogin.getEmail());
            myResponse.setResponseCode(ResponseCode.OPERATION_SUCCESSFUL.getCode());
            myResponse.setItems(caseHistories);
        }catch (Exception e){
            myResponse.setResponseCode(ResponseCode.DATABASE_ERROR.getCode());
            List<String> errors = new ArrayList<String>();
            errors.add(new String("Unexpected error.. Try Again Later"));
            myResponse.setErrors(errors);
        }
        return myResponse;
    }

}


