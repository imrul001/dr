package dr.hasan.common.enums;

/**
 * @author Imrul Hasan
 * @date 23/03/19
 */
public enum Status {
    ACTIVE("Active", 'Y'),
    CLOSED("Closed", 'N');

    public String status;
    public char code;

    Status(String status, char code){
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public char getCode() {
        return code;
    }

    public static String getStatusByCode(char code){
        String statusStr = null;
        for(Status status : values()){
            if(status.getCode() == code){
                statusStr = status.status;
                break;
            }
        }
        return statusStr;
    }
}
