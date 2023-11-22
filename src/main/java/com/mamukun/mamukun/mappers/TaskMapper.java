package com.mamukun.mamukun.mappers;

import org.mapstruct.Mapper;
import com.mamukun.mamukun.entities.Task;
import com.mamukun.mamukun.model.TaskDTO;

@Mapper
public interface TaskMapper {
    Task taskDtoToTask(TaskDTO dto);
    TaskDTO taskToTaskDto(Task task);
}
