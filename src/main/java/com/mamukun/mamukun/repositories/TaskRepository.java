package com.mamukun.mamukun.repositories;

import com.mamukun.mamukun.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
