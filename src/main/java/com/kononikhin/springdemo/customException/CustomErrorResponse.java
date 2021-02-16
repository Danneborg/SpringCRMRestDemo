package com.kononikhin.springdemo.customException;

public class CustomErrorResponse {
    private int error;
    private String message;
    private long timeStamp;

    public CustomErrorResponse() {
    }

    public CustomErrorResponse(int error, String message, long timeStamp) {
        this.error = error;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "CustomErrorResponse{" +
                "error=" + error +
                ", message='" + message + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
