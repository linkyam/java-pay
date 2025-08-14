package com.api.exception;

import java.io.Serializable;

public class ErrorCode implements IError, Serializable {
    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorInfo;

    public ErrorCode() {
    }

    public ErrorCode(String errorCode, String errorInfo) {
        this.errorCode = errorCode;
        this.errorInfo = errorInfo;
    }

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorInfo() {
        return this.errorInfo;
    }
}
