package dr.hasan.util;

import dr.hasan.casesconversation.entity.CaseHistory;
import dr.hasan.casesconversation.entity.Conversation;
import dr.hasan.casesconversation.model.CaseHistoryDTO;
import dr.hasan.casesconversation.model.ConversationDTO;
import dr.hasan.common.enums.Status;
import dr.hasan.common.enums.YesNo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Imrul Hasan
 * @date 09/03/19
 */
public class ModelConverterUtil {

    public static List<CaseHistoryDTO> getCaseHistoryDTO(List<CaseHistory> caseHistories) {
        List<CaseHistoryDTO> caseHistoryDTOS = new ArrayList<>();
        caseHistories.stream().forEach(p -> {
            List<ConversationDTO> conversationDTOS = new ArrayList<>();
            p.getConversations().stream().forEach(q -> {
                ConversationDTO conversationDTO = new ConversationDTO();
                conversationDTO.setCreatedBy(q.getCreatedBy());
                conversationDTO.setConversionId(q.getId());
                conversationDTO.setCreatedDate(q.getDate());
                conversationDTO.setTextContent(q.getContent());
                conversationDTO.setImageContent(q.getImage_id());
                conversationDTOS.add(conversationDTO);
            });
            CaseHistoryDTO caseHistoryDTO = new CaseHistoryDTO(
                    p.getClientId(), p.getSubject(), p.getId(), Status.getStatusByCode(p.getStatus()), conversationDTOS);
            caseHistoryDTOS.add(caseHistoryDTO);
        });
        return caseHistoryDTOS;
    }


    public static CaseHistory getEntityFromDTO(CaseHistoryDTO caseHistoryDTO){
        CaseHistory caseHistory = new CaseHistory();
        Conversation conversation = new Conversation();
        List<Conversation> conversationList = new ArrayList<>();
        caseHistory.setSubject(caseHistoryDTO.getSubject());
        caseHistory.setClientId(caseHistoryDTO.getClientId());
        caseHistory.setStatus(YesNo.YES.getCode());
        conversation.setContent(caseHistoryDTO.getTextContent());
        conversation.setCaseHistory(caseHistory);
        conversation.setDate(new Date());
        conversationList.add(conversation);
        caseHistory.setConversations(conversationList);
        return caseHistory;
    }
}
