package org.jon.lv.exception;


public class TokenException extends Exception{
    private static final long serialVersionUID = -8198281171334131008L;

    private int errCode;

    public TokenException() {}

    public TokenException(String message) { super(message, null);}

    public TokenException(int errCode, String message,
                          Exception exception) {
        super(message, exception);

        this.errCode = errCode;
    }

    public TokenException(int errCode, String message) {
        this(errCode, message,null);
    }

    public int getErrCode() {
        return this.errCode;
    }
}
