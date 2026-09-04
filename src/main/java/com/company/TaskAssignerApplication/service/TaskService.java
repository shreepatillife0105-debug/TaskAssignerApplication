package com.company.TaskAssignerApplication.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.TaskAssignerApplication.dto.TaskRequest;
import com.company.TaskAssignerApplication.model.Intern;
import com.company.TaskAssignerApplication.model.Task;
import com.company.TaskAssignerApplication.repository.InternRepository;
import com.company.TaskAssignerApplication.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
    private TaskRepository taskRepository;

    @Autowired
    private InternRepository internRepository;

    @Autowired
    private EmailService emailService;

    public Task assignTask(TaskRequest request) {
    	Intern intern = internRepository.findById(request.getInternId())
                .orElseThrow(() -> new RuntimeException("Intern not found with id: " + request.getInternId()));

        // Check if same task already assigned to this intern
        Optional<Task> existingTask = taskRepository.findByTitleAndAssignedToId(
                request.getTitle(), 
                request.getInternId()
        );

        if (existingTask.isPresent()) {
            throw new RuntimeException("This task is already assigned to " + intern.getName());
        }

        // Create new task
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus("PENDING");
        task.setAssignedAt(LocalDateTime.now());
        task.setAssignedTo(intern);

        Task savedTask = taskRepository.save(task);

        // Send email
        emailService.sendTaskEmail(
                intern.getEmail(),
                intern.getName(),
                savedTask.getTitle(),
                savedTask.getDescription()
        );

        return savedTask;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByIntern(Long internId) {
        return taskRepository.findByAssignedToId(internId);
    }
    
    public List<Task> getTasksByDate(LocalDate date) {
        return taskRepository.findByAssignedDate(date);
    }

   

}
