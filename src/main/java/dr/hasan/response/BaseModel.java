package dr.hasan.response;

import java.util.ArrayList;
import java.util.List;

public class BaseModel {

    private int responseCode;
    private List<String> errors;

    public BaseModel(){
            errors = new ArrayList<String>();
        }

    public int getResponseCode() {
            return responseCode;
        }

    public void setResponseCode(int responseCode) {
            this.responseCode = responseCode;
        }

    public List<String> getErrors() {
            return errors;
        }

    public void setErrors(List<String> errors) {
            this.errors = errors;
        }

}
