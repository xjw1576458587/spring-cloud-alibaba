package com.xie.videoservice.dto;

public class ResponseObject<T> {
    private String code;
    private String message;
    private T data;

    public ResponseObject(){

    }

    public ResponseObject(T... data){
        this.code = "0";
        this.message = "success";
        if(data.length>0){
            this.data = data[0];
        }
    }

    public ResponseObject(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseObject(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
