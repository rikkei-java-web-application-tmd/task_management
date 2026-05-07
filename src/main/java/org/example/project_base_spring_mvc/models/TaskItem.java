package org.example.project_base_spring_mvc.models;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class TaskItem {

    private String id;

    @NotBlank(message = "Tên công việc không được để trống")
    @Size(min = 5, message = "Tên công việc phải có tối thiểu 5 ký tự")
    private String title;

    @NotNull(message = "Hạn hoàn thành không được để trống")
    @Future(message = "Hạn hoàn thành phải là một ngày ở tương lai")
    private LocalDate deadline;

    @Pattern(regexp = "^(HIGH|MEDIUM|LOW)$", message = "Mức độ ưu tiên chỉ nhận HIGH, MEDIUM, hoặc LOW")
    private String priority;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public LocalDate getDeadline() { return deadline; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
}

