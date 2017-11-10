package dr.hasan.response;

public enum ResponseCode {
    OPERATION_SUCCESSFUL(100),
    RECORD_NOT_FOUND(101),
    AUTHENTICATION_FAILED(1102),
    INVALID_ARGUMENT(103),
    INVALID_TRANSACTION_PASSWORD(104),
    SECURITY_ERROR(106),
    DATABASE_ERROR(110),
    RUNTIME_ERROR(500),
    REMOTE_ERROR(502),
    INTERNAL_CONNECTION_ERROR(503),
    INTERNAL_REMOTE_ERROR(1501);

    private int code;

    private ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
