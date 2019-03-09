package dr.hasan.casesconversation.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "conversation")
public class Conversation{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "conversation_id")
    private long id;

    @Column(name = "created_by")
    private char createdBy;

    @Column(name = "text_content")
    private String content;

    @Column(name ="created_date")
    private Date date;

    @Column(name = "image_id")
    private long image_id;

    @ManyToOne
    @JoinColumn(name = "case_history_id")
    private CaseHistory caseHistory;

    public Conversation() {
    }

    public Conversation(char createdBy, String content, Date date, long image_id) {
        this.createdBy = createdBy;
        this.content = content;
        this.date = date;
        this.image_id = image_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(char createdBy) {
        this.createdBy = createdBy;
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

    public CaseHistory getCaseHistory() {
        return caseHistory;
    }

    public void setCaseHistory(CaseHistory caseHistory) {
        this.caseHistory = caseHistory;
    }
}
