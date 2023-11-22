package com.mamukun.mamukun.services;

import com.mamukun.mamukun.model.TaskDTO;
import org.springframework.data.domain.Page;

public interface TaskService {
    Page<TaskDTO> listTasks();
}
