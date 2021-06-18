package com.milan.dukan.api;

import java.math.BigInteger;

public class AuthResponse {

    private final String response;
    private final String message;
    private final BigInteger pk;
    private final String email;
    private final String token;

    public AuthResponse(String response, String message, BigInteger pk, String email, String token) {
        this.response = response;
        this.message = message;
        this.pk = pk;
        this.email = email;
        this.token = token;
    }

    public String getResponse() {
        return response;
    }

    public String getMessage() {
        return message;
    }

    public BigInteger getPk() {
        return pk;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "response='" + response + '\'' +
                ", message='" + message + '\'' +
                ", pk=" + pk +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
