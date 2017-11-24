package dr.hasan.casesconversation.entity;

import javax.persistence.Entity;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "CASE_HISTORY")
public class CaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CASE_HISTORY_ID")
    private long id;

    @Column(name = "is_active")
    private char isActive;

    @Column(name = "PATIENT_EMAIL")
    private String patientEmail;

    @Column(name = "PATIENT_ID")
    private long patientId;

    @OneToMany(mappedBy = "caseHistory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Conversation> conversations;

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getIsActive() {
        return isActive;
    }

    public void setIsActive(char isActive) {
        this.isActive = isActive;
    }

    public List<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

}
