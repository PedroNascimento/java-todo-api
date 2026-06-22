package com.n8flow.todo_api.repository;

import com.n8flow.todo_api.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends  JpaRepository<Task, UUID> {
    Page<Task> findByUserId(UUID userId, Pageable pageable);
    Optional<Task> findByIdAndUserId(UUID id, UUID userId);
}
