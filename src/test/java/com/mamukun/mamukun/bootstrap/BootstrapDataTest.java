package com.mamukun.mamukun.bootstrap;

import com.mamukun.mamukun.repositories.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BootstrapDataTest {

    @Autowired
    TaskRepository taskRepository;

    BootstrapData bootstrapData;

    @BeforeEach
    void setUp() {
        bootstrapData = new BootstrapData(taskRepository);
    }

    @Test
    void testTaskCount() throws Exception {
        bootstrapData.run((String) null);
        Assertions.assertEquals(taskRepository.count(),3);
    }
}
