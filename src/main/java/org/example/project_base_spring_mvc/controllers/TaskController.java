package org.example.project_base_spring_mvc.controllers;

import jakarta.validation.Valid;
import org.example.project_base_spring_mvc.models.TaskItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final List<TaskItem> taskList = new ArrayList<>();

    public TaskController() {
        TaskItem mockTask = new TaskItem();
        mockTask.setId("T-" + UUID.randomUUID().toString().substring(0, 4).toUpperCase());
        mockTask.setTitle("Hoàn thành bài kiểm tra Spring MVC");
        mockTask.setDeadline(LocalDate.now().plusDays(3));
        mockTask.setPriority("HIGH");
        taskList.add(mockTask);
    }

    @GetMapping
    public String showTaskList(Model model) {
        model.addAttribute("tasks", taskList);
        return "task-list";
    }

    @GetMapping("/add")
    public String showTaskForm(Model model) {
        model.addAttribute("taskItem", new TaskItem());
        return "task-form";
    }

    @PostMapping("/add")
    public String saveTask(@Valid @ModelAttribute("taskItem") TaskItem taskItem, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "task-form";
        }

        taskItem.setId("T-" + UUID.randomUUID().toString().substring(0, 4).toUpperCase());
        taskList.add(taskItem);

        return "redirect:/tasks";
    }
}

