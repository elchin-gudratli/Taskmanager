package com.taskmanager.taskmanager.payload;

import java.io.Serializable;

public class JWTLoginSuccessResponse implements Serializable {


    private boolean success;
    private String token;

    public JWTLoginSuccessResponse(boolean success, String token) {
        this.success = success;
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "JWTLoginSuccessReponse{" +
                "success=" + success +
                ", token='" + token + '\'' +
                '}';
    }

}
