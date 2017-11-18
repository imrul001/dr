package dr.hasan.casesconversation.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CONVERSATION")
public class Conversation{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONVERSATION_ID")
    private long id;

    @Column(name = "is_active")
    private char isActive;


    @Column(name = "CASE_ID")
    private long case_id;

    @Column(name = "PATIENT_STATEMENT")
    private String patientStatement;

    @Column(name = "DOCTOR_REVIEW")
    private String doctorReview;

    @Column(name ="ISSUE_DATE")
    private Date date;

    @Column(name = "IMAGE_ID")
    private long image_id;

    public long getCase_id() {
        return case_id;
    }

    public void setCase_id(long case_id) {
        this.case_id = case_id;
    }

    public String getPatientStatement() {
        return patientStatement;
    }

    public void setPatientStatement(String patientStatement) {
        this.patientStatement = patientStatement;
    }

    public String getDoctorReview() {
        return doctorReview;
    }

    public void setDoctorReview(String doctorReview) {
        this.doctorReview = doctorReview;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getImage_id() {
        return image_id;
    }

    public void setImage_id(long image_id) {
        this.image_id = image_id;
    }
}
