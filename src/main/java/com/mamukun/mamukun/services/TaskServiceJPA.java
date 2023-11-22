package com.mamukun.mamukun.services;

import com.mamukun.mamukun.entities.Task;
import com.mamukun.mamukun.mappers.TaskMapper;
import com.mamukun.mamukun.model.TaskDTO;
import com.mamukun.mamukun.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class TaskServiceJPA implements TaskService {

    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    private final static int DEFAULT_PAGE=0;
    private final static int DEFAULT_PAGE_SIZE=25;

    @Override
    public Page<TaskDTO> listTasks() {
        PageRequest pageRequest = buildPageRequest(DEFAULT_PAGE,DEFAULT_PAGE_SIZE);
        Page<Task> taskPage;
       taskPage = taskRepository.findAll(pageRequest);
       return taskPage.map(taskMapper::taskToTaskDto);
    }

    public PageRequest buildPageRequest(Integer pageNumber, Integer pageSize) {
        int queryPageNumber;
        int queryPageSize;

        if (pageNumber != null && pageNumber > 0) {
            queryPageNumber = pageNumber - 1;
        } else {
            queryPageNumber = DEFAULT_PAGE;
        }

        if (pageSize == null) {
            queryPageSize = DEFAULT_PAGE_SIZE;
        } else {
            if (pageSize > 1000) {
                queryPageSize = 1000;
            } else {
                queryPageSize = pageSize;
            }
        }
        Sort sort = Sort.by(Sort.Order.asc("taskTitle"));
        return PageRequest.of(queryPageNumber, queryPageSize, sort);
    }
}
