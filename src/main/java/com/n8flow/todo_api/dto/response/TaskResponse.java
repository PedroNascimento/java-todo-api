package com.n8flow.todo_api.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskResponse (
        UUID id,
        String title,
        String description,
        boolean completed,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){}
