/**
 * 
 */
package com.oto.kyc.service.exception;

/**
 * @author thuyntp
 *
 */
public class ServiceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3293816712482266214L;
private int errorCode;
    
    public ServiceException() {
    }
    
    public ServiceException(int errorCode) {
        this.errorCode = errorCode;
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * get value of <b>errorCode</b>.
     * @return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Set value to <b>errorCode</b>.
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
