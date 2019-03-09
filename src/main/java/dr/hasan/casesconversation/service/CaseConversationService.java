package dr.hasan.casesconversation.service;


import dr.hasan.casesconversation.entity.CaseHistory;
import dr.hasan.casesconversation.entity.Conversation;
import dr.hasan.casesconversation.model.CaseHistoryDTO;
import dr.hasan.casesconversation.repository.CaseHistoryRepository;
import dr.hasan.casesconversation.repository.ConversationRepository;
import dr.hasan.clientLogin.entity.UserLogin;
import dr.hasan.response.MyResponse;
import dr.hasan.response.Response;
import dr.hasan.response.ResponseCode;
import dr.hasan.util.ModelConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CaseConversationService {

    @Autowired
    private CaseHistoryRepository caseHistoryRepository;

    @Autowired
    private ConversationRepository conversationRepository;

    public Response createCaseConversation(CaseHistory caseHistory){

        Response response = new Response();
        try {
//            CaseHistory caseHistory = new CaseHistory();
//            caseHistory.setStatus('Y');
//            //caseHistory.setPatientEmail("bimpu@gmail.com");
//            caseHistory.setClientId(1);
//
//            Conversation conversation = new Conversation();
//            conversation.setContent("Test Content from patient");
//            conversation.setDate(new Date());
//            conversation.setImage_id(123);
//            //conversation.set('Y');
////            conversation.setCaseHistory(caseHistory);
//
//            Conversation conversation1 = new Conversation();
//            conversation1.setContent("Second Test Content from patient");
//            conversation1.setDate(new Date());
//            conversation1.setImage_id(321);
//            //conversation1.setIsActive(YesNo.YES.getCode());
////            conversation1.setCaseHistory(caseHistory);
//
//
//            List<Conversation> conversationList = new ArrayList<Conversation>();
//            conversationList.add(conversation);
//            conversationList.add(conversation1);
//
//            caseHistory.setConversations(conversationList);

            caseHistoryRepository.create(caseHistory);
            response.setResponseCode(ResponseCode.OPERATION_SUCCESSFUL.getCode());
            response.setResponseMessage("Operation Successful");

        }catch (Exception e){
            response.setResponseCode(ResponseCode.DATABASE_ERROR.getCode());
            response.setResponseMessage("error due to :"+e.getMessage());
        }
        return response;

    }

    public Response createConversation(Conversation conversation){
        Response response = new Response();
        try {
            conversationRepository.create(conversation);
            response.setResponseMessage("Operation Successful");
            response.setResponseCode(ResponseCode.OPERATION_SUCCESSFUL.getCode());
        }catch (Exception e){
            response.setResponseCode(ResponseCode.DATABASE_ERROR.getCode());
            response.setResponseMessage("error due to :"+e.getMessage());
        }
        return response;
    }

    public MyResponse<List<CaseHistoryDTO>> getCaseHistory(UserLogin userLogin){
        MyResponse myResponse = new MyResponse();
        List<CaseHistory> caseHistories;
        try{
            caseHistories = caseHistoryRepository.getCaseHistoryByClientId(userLogin.getClientId());
            List<CaseHistoryDTO> caseHistoryDTOS = ModelConverterUtil.getCaseHistoryDTO(caseHistories);
            myResponse.setResponseCode(ResponseCode.OPERATION_SUCCESSFUL.getCode());
            myResponse.setItems(caseHistoryDTOS);
        }catch (Exception e){
            myResponse.setResponseCode(ResponseCode.DATABASE_ERROR.getCode());
            List<String> errors = new ArrayList<String>();
            errors.add(new String("Unexpected error.. Try Again Later"));
            myResponse.setErrors(errors);
        }
        return myResponse;
    }




}


