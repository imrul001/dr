package dr.hasan.casesconversation.entity;

import javax.persistence.Entity;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "case_history")
public class CaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "case_history_id")
    private long id;

    @Column(name = "status")
    private char status ;

    @Column(name = "client_id")
    private long clientId;

    @Column(name = "subject")
    private String subject;

    @OneToMany(mappedBy = "caseHistory", cascade = CascadeType.ALL)
    private List<Conversation> conversations;

    public CaseHistory() {
    }

    public CaseHistory(char status, long clientId, String subject) {
        this.status = status;
        this.clientId = clientId;
        this.subject = subject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
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

    public List<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;
    }
}
