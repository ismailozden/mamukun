package com.mamukun.mamukun.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Builder
@Data
public class TaskDTO {
    private UUID id;
    private Integer version;
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String taskTitle;
}
