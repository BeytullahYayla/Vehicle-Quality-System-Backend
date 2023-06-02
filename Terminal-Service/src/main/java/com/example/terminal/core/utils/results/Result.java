package com.example.terminal.core.utils.results;

public class Result {

    private Boolean success;
    private String message;
    public Result(boolean success) {//We may want to send just success info
        this.success=success;

    }
    public Result(boolean success,String message) {//Or with message info
        this(success);
        this.message=message;
    }
    public boolean isSuccess() {
        return this.success;
    }
    public String getMessage() {
        return this.message;
    }
}
