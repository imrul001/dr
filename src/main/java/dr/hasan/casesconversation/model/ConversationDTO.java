package dr.hasan.casesconversation.model;

import java.util.Date;

/**
 * @author Imrul Hasan
 * @date 09/03/19
 */
public class ConversationDTO {
    private long conversionId;
    private String textContent;
    private long imageContent;
    private char createdBy;
    private Date createdDate;

    public long getConversionId() {
        return conversionId;
    }

    public void setConversionId(long conversionId) {
        this.conversionId = conversionId;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public long getImageContent() {
        return imageContent;
    }

    public void setImageContent(long imageContent) {
        this.imageContent = imageContent;
    }

    public char getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(char createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
