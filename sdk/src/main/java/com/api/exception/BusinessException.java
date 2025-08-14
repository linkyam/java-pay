
package com.api.exception;

/**
 * 业务异常
 * <pre>
 *    继承RuntimeException,程序无需强制捕获，但顶层需处理
 * </pre>
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	protected String errorCode;
	
	public BusinessException() {}
	
	public BusinessException(IError error) {
	    super(error.getErrorInfo());
	    this.errorCode = error.getErrorCode();
	}

	public BusinessException(String errorCode, String errorInfo) {
		super(errorInfo);
		this.errorCode = errorCode;
	}

	public BusinessException(String errorCode, String errorInfo, Throwable e) {
		super(errorInfo, e);
		this.errorCode = errorCode;
	}

	public BusinessException(String errorCode, Throwable e) {
		super(e);
		this.errorCode = errorCode;
	}

	public BusinessException(Throwable e) {
		super(e);
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public String getErrorInfo() {
		return this.getMessage();
	}

	@Override
	public String toString() {
		return "BusinessException{" +
				"errorCode='" + errorCode + '\'' +
				'}';
	}
}
