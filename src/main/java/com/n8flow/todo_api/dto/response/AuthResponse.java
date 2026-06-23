package com.n8flow.todo_api.dto.response;

public record AuthResponse (
        String token,
        String tokenType,
        long expiresIn
){
    public static AuthResponse of (String token, long expiresIn){
        return new AuthResponse(token, "Bearer", expiresIn);
    }
}
