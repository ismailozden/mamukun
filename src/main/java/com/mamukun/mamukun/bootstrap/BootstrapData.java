package com.mamukun.mamukun.bootstrap;

import com.mamukun.mamukun.entities.Task;
import com.mamukun.mamukun.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private final TaskRepository taskRepository;
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        loadTaskData();
    }

    private void loadTaskData() {
        if(taskRepository.count() == 0){
            Task task1 = Task.builder()
                    .taskTitle("This is the first task.").build();
            Task task2 = Task.builder()
                    .taskTitle("This is the second task.").build();
            Task task3 = Task.builder()
                    .taskTitle("This is the third task.").build();

            taskRepository.save(task1);
            taskRepository.save(task2);
            taskRepository.save(task3);

        }
    }

}
