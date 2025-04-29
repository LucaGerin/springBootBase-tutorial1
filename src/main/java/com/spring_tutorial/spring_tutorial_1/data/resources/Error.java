package com.spring_tutorial.spring_tutorial_1.data.resources;

public class Error {

    private String errorType;
    private String message;

    public Error(String errorType, String message) {
        this.errorType = errorType;
        this.message = message;
    }
    public String getErrorType() {
        return errorType;
    }
    public String getMessage() {
        return message;
    }

}
