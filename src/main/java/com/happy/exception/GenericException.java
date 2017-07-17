package com.happy.exception;

/**
 * Created by lirongbo on 2017/7/7.
 */
public class GenericException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;



    public GenericException() {
        super();
    }

    public GenericException(String errorCode,String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    public GenericException(String message) {
        super(message);
    }

    public GenericException(Throwable cause) {
        super(cause);
    }

    public GenericException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}