package taskosaurus.task.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import taskosaurus.task.model.Task;
import taskosaurus.task.repository.TaskRepository;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskRepository taskRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public Task createTask(@RequestBody Task task, @AuthenticationPrincipal Jwt jwt) {
        task.setUserId(jwt.getSubject());
        Task savedTask = taskRepository.save(task);

        // Отправка события в Kafka
        kafkaTemplate.send("task-created", savedTask.getId(), savedTask.toString());

        return savedTask;
    }
}