package com.company.TaskAssignerApplication.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.TaskAssignerApplication.dto.TaskRequest;
import com.company.TaskAssignerApplication.model.Task;
import com.company.TaskAssignerApplication.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin
public class TaskController {
	
	@Autowired
    private TaskService taskService;

    @PostMapping
    public Task assignTask(@RequestBody TaskRequest request) {
        return taskService.assignTask(request);
    }

    @GetMapping
    public List<Task> getAllTasks(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        if (date != null) {
            return taskService.getTasksByDate(date);
        }
        return taskService.getAllTasks();
    }

    @GetMapping("/intern/{internId}")
    public List<Task> getTasksByIntern(@PathVariable Long internId) {
        return taskService.getTasksByIntern(internId);
    }

}
