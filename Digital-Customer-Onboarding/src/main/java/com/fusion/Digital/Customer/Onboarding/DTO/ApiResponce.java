package com.fusion.Digital.Customer.Onboarding.DTO;

import lombok.Data;

@Data
public class ApiResponce<T> {

    private String message;

    private T data;

    public ApiResponce() {

    }

    public ApiResponce(String message, T data) {
        this.message = message;
        this.data = data;
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

    public static<T> ApiResponce<T> success(String message, T data){
        return new ApiResponce<>(message, data);
    }

    public static<T> ApiResponce<T> success(String message){
        return success(message , null);
    }

    public static<T> ApiResponce<T> error(String message, T data){
        return new ApiResponce<>(message,data);
    }

    public static<T> ApiResponce<T> error(String message){
        return error(message , null);
    }
}
