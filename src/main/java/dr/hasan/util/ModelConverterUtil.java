package dr.hasan.util;

import dr.hasan.casesconversation.entity.CaseHistory;
import dr.hasan.casesconversation.model.CaseHistoryDTO;
import dr.hasan.casesconversation.model.ConversationDTO;

import java.util.ArrayList;
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
                    p.getClientId(), p.getSubject(), p.getId(), p.getStatus(), conversationDTOS);
            caseHistoryDTOS.add(caseHistoryDTO);
        });
        return caseHistoryDTOS;
    }
}
