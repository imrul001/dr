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

    @Column(name = "CREATED_BY")
    private long createdBy;

    @Column(name = "is_active")
    private char isActive;

    @Column(name = "content")
    private String content;

    @Column(name ="CREATION_DATE")
    private Date date;

    @Column(name = "IMAGE_ID")
    private long image_id;

    @ManyToOne
    @JoinColumn(name = "CASE_HISTORY_ID")
    private CaseHistory caseHistory;

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

    public CaseHistory getCaseHistory() {
        return caseHistory;
    }

    public void setCaseHistory(CaseHistory caseHistory) {
        this.caseHistory = caseHistory;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
