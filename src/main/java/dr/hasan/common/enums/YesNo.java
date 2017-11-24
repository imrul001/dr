package dr.hasan.common.enums;

public enum YesNo {
    YES('Y'),
    NO('N');

    public char code;

    private YesNo(char code){
        this.code = code;
    }

    public char getCode() {
        return code;
    }
}
