package dr.hasan.response;

import java.util.List;

/**
 * Created by Imrul on 9/11/2017.
 */
public class Response {

    private long responseCode;
    private String responseMessage;
    private List<String> errors;

    public long getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(long responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
