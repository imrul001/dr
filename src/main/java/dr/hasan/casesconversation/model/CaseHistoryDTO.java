package dr.hasan.casesconversation.model;

import java.util.List;

/**
 * @author Imrul Hasan
 * @date 09/03/19
 */
public class CaseHistoryDTO {

    private long clientId;
    private String subject;
    private long caseHistoryId;
    private String status;
    private List<ConversationDTO> conversationDTOList;

    private String textContent;


    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public CaseHistoryDTO(long clientId, String subject, long caseHistoryId, String status, List<ConversationDTO> conversationDTOList) {
        this.clientId = clientId;
        this.subject = subject;
        this.caseHistoryId = caseHistoryId;
        this.status = status;
        this.conversationDTOList = conversationDTOList;
    }

    public CaseHistoryDTO() {
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public long getCaseHistoryId() {
        return caseHistoryId;
    }

    public void setCaseHistoryId(long caseHistoryId) {
        this.caseHistoryId = caseHistoryId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ConversationDTO> getConversationDTOList() {
        return conversationDTOList;
    }

    public void setConversationDTOList(List<ConversationDTO> conversationDTOList) {
        this.conversationDTOList = conversationDTOList;
    }
}
