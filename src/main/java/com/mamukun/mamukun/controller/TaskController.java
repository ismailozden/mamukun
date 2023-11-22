package com.mamukun.mamukun.controller;

import com.mamukun.mamukun.model.TaskDTO;
import com.mamukun.mamukun.services.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TaskController {

    private static final String TASK_PATH = "/api/v1/task";

    private final TaskService taskService;

    @GetMapping(TASK_PATH)
    public Page<TaskDTO> listTasks(){
        return taskService.listTasks();
    }


}
