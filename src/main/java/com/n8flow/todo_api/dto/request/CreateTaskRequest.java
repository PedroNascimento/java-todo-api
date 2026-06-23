package com.n8flow.todo_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTaskRequest (
        @NotBlank(message = "Título é obrigatório")
        @Size(max = 255)
        String title,

        @Size(max = 2000)
        String description
) {}
