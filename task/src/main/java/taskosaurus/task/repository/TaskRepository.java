package taskosaurus.task.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import taskosaurus.task.model.Task;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByUserId(String userId);
}