package dr.hasan.casesconversation.service;


import dr.hasan.casesconversation.entity.CaseHistory;
import dr.hasan.casesconversation.entity.Conversation;
import dr.hasan.casesconversation.repository.CaseHistoryRepository;
import dr.hasan.casesconversation.repository.ConversationRepository;
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
            caseHistory.setPatientEmail("test@gmail.com");
            caseHistory.setPatientId(123);
            Conversation conversation = new Conversation();
            conversation.setContent("Test Content from patient");
            conversation.setDate(new Date());
            conversation.setImage_id(123);
            conversation.setIsActive('Y');
            conversation.setCaseHistory(caseHistory);
            List<Conversation> conversationList = new ArrayList<Conversation>();
            conversationList.add(conversation);
            caseHistory.setConversations(conversationList);

            caseHistoryRepository.create(caseHistory);
//            conversationRepository.create(conversation);
            response.setResponseCode(ResponseCode.OPERATION_SUCCESSFUL.getCode());

        }catch (Exception e){
            response.setResponseCode(ResponseCode.DATABASE_ERROR.getCode());
        }
        return response;

    }

}


