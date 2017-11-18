package dr.hasan.casesconversation.entity;

import javax.persistence.Entity;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "CASE_HISTORY")
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CASE_ID")
    private long id;

    @Column(name = "is_active")
    private char isActive;

    @Column(name = "PATIENT_EMAIL")
    private String patientEmail;


    @Column(name = "DOCTOR_EMAIL")
    private String doctorEmail;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name="CASE_CONVERSATION", joinColumns = {@JoinColumn(name = "CASE_ID")}, inverseJoinColumns = {@JoinColumn(name="CONVERSATION_ID")})
    private List<Conversation> conversations;

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

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctoerEmail) {
        this.doctorEmail = doctoerEmail;
    }
}
